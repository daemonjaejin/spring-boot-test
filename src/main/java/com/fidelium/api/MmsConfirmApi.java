package com.fidelium.api;

import com.fidelium.domain.Message.MmsResponse;
import com.fidelium.domain.Message.MmsSendVO;
import com.fidelium.service.MmsService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jin on 17. 11. 19.
 */
@RequestMapping(value = "/message")
@RestController
public class MmsConfirmApi {

    @Autowired
    private MmsService mmmService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/messageSend", method = RequestMethod.POST)
    public @ResponseBody MmsSendVO messageSend(@RequestBody MmsSendVO mmsSendVO){
        logger.info("{}", mmsSendVO.toString());
        if(Strings.isNullOrEmpty(mmsSendVO.getTo())){
            return new MmsSendVO("fail", "to 파라미터 누락");
        }
        return mmmService.messageSend(mmsSendVO);
    }

    @RequestMapping(value = "/response", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody MmsResponse response(HttpServletRequest request, @RequestBody MmsSendVO mmsSendVO){
        System.out.println("response!!!");
        logger.info("mmsSendVO.toString() : {}", mmsSendVO.toString());
        Map<String, String[]> map = request.getParameterMap();
        if (map != null) {
            for (String key : map.keySet()) {
                logger.info("key : <{}>", key);
                if (map.get(key) != null) {
                    String[] array = map.get(key);
                    for (String str : array) {
                        if (!Strings.isNullOrEmpty(str)) {
                            logger.info("str : <{}>", str);
                        }
                    }
                }
            }
        }
        mmsSendVO = mmmService.selectMmsSendInfo(mmsSendVO);
        logger.info("mmsSendVO.toString() : {} : ", mmsSendVO.toString());
        return new MmsResponse(mmsSendVO.getMessageId(), mmsSendVO.getTo());
    }

    public static void main(String [] args){
        MmsConfirmApi mc = new MmsConfirmApi();
//        mc.authSend();
        MmsSendVO mmsSendVO = new MmsSendVO();
        mmsSendVO.setTo("821025810627");
        mc.messageSend(mmsSendVO);
    }

}
