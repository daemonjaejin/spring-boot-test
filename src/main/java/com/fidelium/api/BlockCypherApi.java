package com.fidelium.api;

import com.fidelium.dao.BatchMapper;
import com.fidelium.domain.BlockCypher.BlockCypherResponse;
import com.fidelium.domain.BlockCypher.request.GenerateWalletReqDTO;
import com.fidelium.domain.BlockCypher.response.GenerateAddrDTO;
import com.fidelium.domain.BlockCypher.response.GenerateWalletDTO;
import com.fidelium.domain.CoinInfo;
import com.fidelium.domain.TradeHistory;
import com.fidelium.domain.TradeHistoryBatch;
import com.fidelium.domain.UserTradeHistory;
import com.fidelium.service.BlockCypherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-31.
 */

@Service
public class BlockCypherApi {

	public static String BLOCKCHYPERTOKEN = "de9d3bb4d6b64ef3aec683b93307ea55";//db화
//	public static String BLOCKCHYPERTOKEN = "74834163424a4265838c91b5614ba2fb";//db화
	public static String BLOCKCHYPERURL = "https://api.blockcypher.com/v1/bcy/test/";//종류별DB화
	
	
    private Logger logger = LoggerFactory.getLogger(getClass());

    private RestTemplate restTemplate;

    private final String URL = "https://api.blockcypher.com/v1/tokens/";
    private final String TOKEN = "ba952a49a6ea4583ae78629ab04ffdd6";
    
    @Autowired
    private BlockCypherService blockCypherService;

    @Autowired
    private BatchMapper batchMapper;
    
    //지갑생성전api 에서 사용 가능한 주소를 받아 온다.
    public GenerateAddrDTO generateAddressApi() {
    		String urlExt = "addrs";
    		restTemplate = new RestTemplate();
    		GenerateAddrDTO response = restTemplate.postForObject(BLOCKCHYPERURL + urlExt, null, GenerateAddrDTO.class);
    		logger.info("지갑생성 <{}>" + response);
    		return response;
    }
    
    //지갑생성
    public GenerateWalletDTO createWalletApi(GenerateWalletReqDTO generateWalletReqDTO) {
    		String urlExt = "wallets?token=" + BLOCKCHYPERTOKEN;
    		restTemplate = new RestTemplate();
    		GenerateWalletDTO generateWalletDTO = restTemplate.postForObject(BLOCKCHYPERURL + urlExt, generateWalletReqDTO, GenerateWalletDTO.class);
    		return generateWalletDTO;
    }
    
    //지갑생성 프로세스
    public int createWalletProccess(CoinInfo coinInfo) {
    		GenerateAddrDTO dto = this.generateAddressApi();
    		GenerateWalletReqDTO generateWalletReqDTO = new GenerateWalletReqDTO();
    		generateWalletReqDTO.setName(dto.getAddress().substring(1,10));
    		generateWalletReqDTO.setAddress(dto.getAddress().split("/"));
    		GenerateWalletDTO walletDTO = this.createWalletApi(generateWalletReqDTO);
    		coinInfo.setId("test10@comapny.com");
    		coinInfo.setType("0");
    		coinInfo.setWalletName(walletDTO.getName());
    		coinInfo.setAddress(dto.getAddress());
    		coinInfo.setPrivateKey(dto.getPrivateKey());
    		coinInfo.setPublicKey(dto.getPublicKey());
    		blockCypherService.createWallet(coinInfo);
    		return 1;
    }
    
    // receive 프로세스
    public int receiveWalletProccess(){
        /*
        * receive API
        * */
        UserTradeHistory userTradeHistory = new UserTradeHistory();
        batchMapper.insertUserTradeHistory(userTradeHistory);
        batchMapper.insertUserTradeHistoryBatch(userTradeHistory);
        return 1;
    }

    // receive 프로세스
    public int tradeWalletProccess(){
        /*
        * trade API
        * */
        TradeHistory tradeHistory = new TradeHistory();
        batchMapper.insertTradeHistory(tradeHistory);
        batchMapper.insertTradeHistoryBatch(tradeHistory);
        return 1;
    }
    
    public void call(){
        logger.info("<{}>", "test");

        restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();
        vars.put("1", "1");
        vars.put("2", "2");

        BlockCypherResponse response = restTemplate.getForObject(this.URL + this.TOKEN, BlockCypherResponse.class, vars);

        logger.info("result <{}>", response.toString());

    }

    public void call2(){
        restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://api.blockcypher.com/v1/btc/main/addrs/1rundZJCMJhUiWQNFS5uT3BvisBuLxkAp?limit=2", String.class);
        logger.info("result <{}>", result);
    }

    public void call3(){
        restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://www.cryptocompare.com/api/data/coinlist/", String.class);
        logger.info("result <{}>", result);
    }

    /**
     * User Trade 확인
     * */
    public void sendUserTradeConfirm(UserTradeHistory userTradeHistory){
        logger.info("{}", userTradeHistory.toString());
        /*
        * API 호출
        * */
//        receiveHistoryBatch.setViewYn("Y");
//        if(batchMapper.updateReceiveHistory(receiveHistoryBatch) == 1){
//            batchMapper.deleteReceiveHistoryBatch(receiveHistoryBatch);
//        }
    }

    /**
     * Trade 확인
     * */
    public void sendTradeConfirm(TradeHistoryBatch tradeHistoryBatch){
        logger.info("{}", tradeHistoryBatch.toString());
        /*
        * API 호출
        * */
//        tradeHistoryBatch.setViewYn("Y");
//        if(batchMapper.updateTradeHistory(tradeHistoryBatch) == 1){
//            batchMapper.deleteTradeHistoryBatch(tradeHistoryBatch);
//        }
    }

}
