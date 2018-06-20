package com.fidelium.api;

import com.fidelium.domain.CryptoCompare.CoinCurrentCompareVO;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017-11-24.
 */

@Service
public class CryptoCompareApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate restTemplate;

    /*
    * 현재 시세
    * */
    private final String MIN_URL = "https://min-api.cryptocompare.com/data/histominute?fsym={coin}&tsym=USD&limit=1&toTs={timestamp}&e=Poloniex";

    /*
    * 현재 가격
    * */
    private final String CURRENT_URL = "https://min-api.cryptocompare.com/data/price?fsym={type}&tsyms={array}";

    /*
    * 코인 리스트
    * */
    private final String COINLIST_URL = "https://www.cryptocompare.com/api/data/coinlist/";

    public void compare(String str){
        restTemplate = new RestTemplate();
        String url = MIN_URL.replace("{coin}", str).replace("{timestamp}", String.valueOf(System.currentTimeMillis()));
        logger.info("<{}>", url);
        String result = restTemplate.getForObject(url, String.class);
        logger.info("result <{}>", result);
    }

    public void current(String type, String [] array){
        restTemplate = new RestTemplate();
        String url = CURRENT_URL.replace("{type}", type).replace("{array}", StringUtils.join(array, ','));
        logger.info("<{}>", url);
        String result = restTemplate.getForObject(url, String.class);
        logger.info("result <{}>", result);
    }

    public void coinList(){
        restTemplate = new RestTemplate();
        String url = COINLIST_URL;
        logger.info("<{}>", url);
        String result = restTemplate.getForObject(url, String.class);
        logger.info("result <{}>", result);
    }

    public CoinCurrentCompareVO getCoinInfo(CoinCurrentCompareVO coinCurrentCompareVO){
        restTemplate = new RestTemplate();
        String url = CURRENT_URL.replace("{type}", coinCurrentCompareVO.getType()).replace("{array}", StringUtils.join(coinCurrentCompareVO.getCoinList(), ','));
        logger.info("<{}>", url);
        CoinCurrentCompareVO result = restTemplate.getForObject(url, CoinCurrentCompareVO.class);
        logger.info("result <{}>", result);
        result.setTitle("success");
        result.setContents("API 질의응답 성공");
        return result;
    }

    public static void main(String [] args){
        CryptoCompareApi cryptoCompareApi = new CryptoCompareApi();
        String [] arr = {"BTC", "ETH", "LTC", "DASH", "USD"};
        for(String str : arr){
            String [] arr2 = (String [])ArrayUtils.removeElement(arr, str);
//            cryptoCompareApi.compare(str);
//            cryptoCompareApi.current(str, arr2);
        }

        String [] arr2 = {"USD"};

//        cryptoCompareApi.coinList();
    }

}
