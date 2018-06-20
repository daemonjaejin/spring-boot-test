package com.fidelium.service;

import com.fidelium.dao.MmsMapper;
import com.fidelium.domain.Message.Destinations;
import com.fidelium.domain.Message.MmsAuthToken;
import com.fidelium.domain.Message.MmsSendVO;
import com.fidelium.util.DateTimeUtil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Random;

/**
 * Created by Administrator on 2017-12-01.
 */

@Transactional
@Service
public class MmsService {

    @Autowired
    private MmsMapper mmsMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final String AUTH_URL = "https://auth.supersms.co:7000/auth/v3/token";

    private final String MESSAGE_URL = "https://sms.supersms.co:7020/sms/v3/multiple-destinations";

    private final String TTL = "600";

    private final String TITLE = "Fidelium";

    private final String FROM = "15992704";

    private RestTemplate restTemplate;

    public MmsAuthToken mmsAuthTokenInfo(){
        return mmsMapper.mmsAuthTokenInfo();
    }

    public MmsAuthToken authSend(){

        MmsAuthToken mmsAuthToken = this.mmsAuthTokenInfo();
        if(mmsAuthToken == null || DateTimeUtil.getTimeLong(-1) > DateTimeUtil.compareStringToDate(mmsAuthToken.getExpired()) ){
            restTemplate = new RestTemplate();

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Accept", "application/json");
            headers.add("X-IB-Client-Id", "fidelium_rest");
            headers.add("X-IB-Client-Passwd", "8AE408D710218P1365ZH");

            HttpEntity<String> request = new HttpEntity<>(headers);

            mmsAuthToken = restTemplate.postForObject(this.AUTH_URL, request, MmsAuthToken.class);
            mmsAuthToken.setKeyValue(1);
            logger.info("authSend : {}", mmsAuthToken.toString());

            mmsMapper.updateInsertAuth(mmsAuthToken);
        }
        return mmsAuthToken;
    }

    public MmsSendVO messageSend(MmsSendVO mmsSendVO){
        restTemplate = new RestTemplate();
        MmsAuthToken mmsAuthToken = this.authSend();
        String authToken = mmsAuthToken.getSchemaValue() + " " + mmsAuthToken.getAccessToken();
        logger.info("{}", authToken);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("content-Type", "application/json");
        headers.add("Authorization", authToken);

        JSONObject jsonObject = new JSONObject();
        String mmsNumber = randomNumber(6);
        jsonObject.put("title", TITLE);
        jsonObject.put("from", FROM);
        jsonObject.put("text", mmsNumber);

        JSONObject inJsonObject = new JSONObject();
        inJsonObject.put("to", mmsSendVO.getTo());
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(inJsonObject);
        jsonObject.put("destinations", jsonArray);
        jsonObject.put("ttl", TTL);
        logger.info("jsonObject.toString() : {}", jsonObject.toString());

        MmsSendVO responseVo = new MmsSendVO();
        try {
            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            ResponseEntity<MmsSendVO> loginResponse = restTemplate.exchange(this.MESSAGE_URL, HttpMethod.POST, request, MmsSendVO.class);
            logger.info("getStatusCode : {}", loginResponse.getStatusCode());
            logger.info("getHeaders : {}", loginResponse.getHeaders());
            logger.info("getBody : {}", loginResponse.getBody());

            if(loginResponse.getStatusCode() == HttpStatus.OK){
                responseVo = loginResponse.getBody();
                responseVo.setTitle("success");
                responseVo.setContents("메시지 전송 성공");
                responseVo.setMmsNum(mmsNumber);
                logger.info("responseVo.toString() : {}", responseVo.toString());
                for (Destinations destination : responseVo.getDestinations()){
                    logger.info("destinations.toString() : {}", destination.toString());
                    responseVo.setMessageId(destination.getMessageId());
                    responseVo.setTo(destination.getTo());
                    responseVo.setStatus(destination.getStatus());
                    responseVo.setErrorText(destination.getErrorText());
                }
                mmsMapper.insertMmsSendResult(responseVo);
            }

        }catch (Exception e){
            logger.debug(e.getMessage());
            responseVo.setTitle("fail");
            responseVo.setContents(e.getMessage());
        }
        return responseVo;
    }

    public MmsSendVO selectMmsSendInfo(MmsSendVO mmsSendVO){
        return mmsMapper.selectMmsSendInfo(mmsSendVO);
    }

    protected String randomNumber(int lastNum){
        String str = "";
        Random generator = new Random();
        for (int i = 0; i < lastNum; i++) {
            str += String.valueOf(generator.nextInt(10));
        }
        return str;
    }

    public static void main(String [] args){
        MmsService mmsService = new MmsService();
//        mmsService.authSend();
        String str = mmsService.randomNumber(6);
        System.out.println(str);
    }

}
