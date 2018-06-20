package com.fidelium.rest;

import com.fidelium.api.BlockCypherApi;
import com.fidelium.domain.*;
import com.fidelium.service.LoginService;
import com.fidelium.service.WalletService;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by jin on 17. 11. 11.
 */

@RequestMapping(value = "/wallet")
@RestController
public class WalletController {

    private static final Logger logger = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private BlockCypherApi blockCypherApi;

    /**
     * 파라미터 ID 와 세션 ID 그리고 security ID 체크
     * */
    protected boolean sessionIdCheck(HttpSession session, Authentication auth, String paramId) throws Exception{
        User user = (User)auth.getPrincipal();
        if(user == null || Strings.isNullOrEmpty(user.getId()) || Strings.isNullOrEmpty(session.getId()) || Strings.isNullOrEmpty(paramId) || !paramId.equals(user.getId())){
            return false;
        }
        return true;
    }

    /**
     * 가상화폐별 지갑 정보를 보여준다.
     * 필수값 : User Id, 가상화폐 타입{"BTC":"비트코인", "ETH":"이더리움", "LTC":"라이트코인", "DASH":"대쉬코인"}
     * */
    @RequestMapping(value = "/getCoinInfo", method = RequestMethod.POST)
     public @ResponseBody CoinInfo getCoinInfo(@RequestBody CoinInfo coinInfo, HttpSession session, Authentication auth){
        try{
            if(sessionIdCheck(session, auth, coinInfo.getId())){
                /*
                * 필수값 유저 id, 가상화폐종류 type
                * */
                CoinInfo result = walletService.getCoinInfo(coinInfo);
                if(result == null){
                    result = new CoinInfo("fail", "값 없음");
                }else{
                    result.setTitle("success");
                    result.setContents("지갑정보");
                }
                return result;
            }else{
                return new CoinInfo("fail", "계정&세션 불일치");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return new CoinInfo("fail", e.getMessage());
        }
    }

    /**
     * 회원 가입후, 지갑 생성 화면
     * 지갑이 있어야만, 다른 서비스를 이용할 수 있다.
     * API를 호출하면, coin_info에 데이터가 들어간다.
     * 지갑 생성후, 4개가 맞다면, User wallet_yn (N->Y)로 변경해준다.
     * 위 로직이 맞지 않는다면 다시 지갑생성을 해야한다.
     * */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Result create(HttpSession session, Authentication auth, @RequestBody CoinInfo coinInfo){
        try {
            if(sessionIdCheck(session, auth, coinInfo.getId())){
                logger.info("User ID : {}", coinInfo.getId());
                // 블록쉬퍼 지갑생성 호출
                int result = this.blockCypherApi.createWalletProccess(coinInfo);
                //                int result = 0;
                // 지갑 계정 생성후 성공이면 유저 정보 업데이트 (지갑생성 여부 N->Y)
                if(result == 1){
                    User user = new User();
                    user.setId(coinInfo.getId());
                    user.setWalletYn("Y");
                    loginService.updateUser(user);
                }
                return new Result("success", "지갑생성");
            }else{
                return new Result("fail", "계정&세션 불일치");
            }
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 가상화폐별 외부에서 데이터를 가지고 온다.
     * 외부에서 가지고 오는 데이터는 최초1회를 가지고 와야한다.
     * */
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public Result receive(HttpSession session, Authentication auth, UserCoin userCoin){

        try {
            if(sessionIdCheck(session, auth, userCoin.getId())){
                // 블록쉬퍼 정보 받기 호출
                //            int result = this.blockCypherApi.createWalletProccess(userCoin); // 수정해야 함
                int result = 0;
                if(result == 1) {

                    /*
                    * 단건으로 종류별로 데이터를 조회하여 업데이트 해준다.
                    * */
                    userCoin = walletService.getUserCoin(userCoin);

                    // 임시 데이터
                    Double emptyD = 0D;
                    Double d = Double.valueOf(userCoin.getCoin());
                    d = d + emptyD;
                    userCoin.setCoin(String.valueOf(d));
                    // user_coin T 데이터 insert/update 하기
                    walletService.userCoinUpdate(userCoin);
                    return new Result("success", "지갑에 데이터 넣기 성공");
                }else{
                    return new Result("fail", "지갑에 데이터 넣기 실패");
                }
            }else{
                return new Result("fail", "계정&세션 불일치");
            }
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Result send(@RequestBody UserCoin userCoin, HttpSession session, Authentication auth){

        User user = (User)auth.getPrincipal();
        logger.info("Session ID : {}", session.getId());
        if(user == null || Strings.isNullOrEmpty(user.getId())){
            return new Result("fail", "세션끊김");
        }else{
            /*
            * 다른 가상화폐 또는 피델리움 지갑으로 코인을 전송한다. (수수료 발생)
            * 최초 1회 receive 없이는 send 할 수 없다.
            * */
            // 블록쉬퍼 정보 받기 호출
//            int result = this.blockCypherApi.createWalletProccess(userCoin); // 수정해야 함
            int result = 0;
            /**
             * 화폐/USD
             * address (상대방 주소)
             * 코인수
             * 수수료
             * */
            if(result == 1){

                /*
                * 단건으로 종류별로 데이터를 조회하여 업데이트 해준다.
                * */
                userCoin = walletService.getUserCoin(userCoin);

                // 임시 데이터
                Double emptyD = 0D;
                Double d = Double.valueOf(userCoin.getCoin());
                d = d + emptyD;
                userCoin.setCoin(String.valueOf(d));
                // user_coin T 데이터 insert/update 하기
                walletService.userCoinUpdate(userCoin);
                return new Result("success", "전송 성공");
            }else{
                return new Result("fail", "전송 실패");
            }
        }
    }

    @RequestMapping(value = "/trade/cell", method = RequestMethod.POST)
    public Result tradeCell(@RequestBody UserCoin userCoin, HttpSession session, Authentication auth){

        User user = (User)auth.getPrincipal();
        logger.info("Session ID : {}", session.getId());
        if(user == null || Strings.isNullOrEmpty(user.getId())){
            return new Result("fail", "세션끊김");
        }else{

            // 블록쉬퍼 정보 받기 호출
//            int result = this.blockCypherApi.createWalletProccess(userCoin); // 수정해야 함
            int result = 0;
            if(result == 1){

                /*
                * 단건으로 종류별로 데이터를 조회하여 업데이트 해준다.
                * */
                userCoin = walletService.getUserCoin(userCoin);

                // 임시 데이터
                Double emptyD = 0D;
                Double d = Double.valueOf(userCoin.getCoin());
                d = d + emptyD;
                userCoin.setCoin(String.valueOf(d));
                // user_coin T 데이터 insert/update 하기
                walletService.userCoinUpdate(userCoin);
                return new Result("success", "구매 성공");
            }else{
                return new Result("fail", "전송 실패");
            }
        }
    }

    @RequestMapping(value = "/trade/buy", method = RequestMethod.POST)
    public Result tradeBuy(@RequestBody UserCoin userCoin, HttpSession session, Authentication auth){

        User user = (User)auth.getPrincipal();
        logger.info("Session ID : {}", session.getId());
        if(user == null || Strings.isNullOrEmpty(user.getId())){
            return new Result("fail", "세션끊김");
        }else {

            // 블록쉬퍼 정보 받기 호출
//            int result = this.blockCypherApi.createWalletProccess(userCoin); // 수정해야 함
            int result = 0;
            if (result == 1) {

                /*
                * 단건으로 종류별로 데이터를 조회하여 업데이트 해준다.
                * */
                userCoin = walletService.getUserCoin(userCoin);

                // 임시 데이터
                Double emptyD = 0D;
                Double d = Double.valueOf(userCoin.getCoin());
                d = d + emptyD;
                userCoin.setCoin(String.valueOf(d));
                // user_coin T 데이터 insert/update 하기
                walletService.userCoinUpdate(userCoin);
                return new Result("success", "매각 성공");
            }else{
                return new Result("fail", "전송 실패");
            }
        }

    }

    /**
     * 코인 매각 리스트
     * */
    @RequestMapping(value = "/trade/cellList", method = RequestMethod.POST)
     public @ResponseBody Result tradeCellList(HttpSession session, Authentication auth, @RequestBody TradeHistory tradeHistory){
        Result result = new Result();
        try {
            if (sessionIdCheck(session, auth, tradeHistory.getId())) {
                result.setTradeHistoryList(walletService.selectTradeList(tradeHistory));
                result.setCount(true);
                result.setTotalNum(walletService.selectTradeList(tradeHistory).get(0).getTotalNum());
                return result;
            }else {
                result.setTitle("fail");
                result.setContents("세션끊김");
                return result;
            }
        }catch (Exception e){
            result.setTitle("fail");
            result.setContents(e.getMessage());
            return result;
        }
    }

    /**
     * 거래 리스트
     * */
    @RequestMapping(value = "/trade/buyList", method = RequestMethod.POST)
    public @ResponseBody Result tradeBuyList(HttpSession session, Authentication auth, @RequestBody TradeHistory tradeHistory){
        Result result = new Result();
        try {
            if (sessionIdCheck(session, auth, tradeHistory.getId())) {
                result.setTradeHistoryList(walletService.selectTradeList(tradeHistory));
                result.setCount(true);
                result.setTotalNum(walletService.selectTradeList(tradeHistory).get(0).getTotalNum());
                return result;
            }else {
                result.setTitle("fail");
                result.setContents("세션끊김");
                return result;
            }
        }catch (Exception e){
            result.setTitle("fail");
            result.setContents(e.getMessage());
            return result;
        }
    }

    /**
     * 코인 매각 정보
     * 유저 id, 종류 type, 거래시간 tradeDatetime
     * */
    @RequestMapping(value = "/trade/cellInfo", method = RequestMethod.POST)
    public TradeHistory tradeCellInfo(HttpSession session, Authentication auth, @RequestBody TradeHistory tradeHistory){
        try {
            if(sessionIdCheck(session, auth, tradeHistory.getId())){
                TradeHistory record = walletService.selectTradeInfo(tradeHistory);
                if(record == null){
                    return new TradeHistory("fail", "데이터없음");
                }else{
                    return record;
                }
            }else{
                return new TradeHistory("fail", "계정&세션 불일치");
            }
        }catch (Exception e){
            return new TradeHistory("fail", e.getMessage());
        }
    }

    /**
     * 코인 구매 정보
     * 유저 id, 종류 type, 거래시간 tradeDatetime
     * */
    @RequestMapping(value = "/trade/buyInfo", method = RequestMethod.POST)
    public TradeHistory tradeBuyInfo(HttpSession session, Authentication auth, @RequestBody TradeHistory tradeHistory){
        try {
            if(sessionIdCheck(session, auth, tradeHistory.getId())){
                TradeHistory record = walletService.selectTradeInfo(tradeHistory);
                if(record == null){
                    return new TradeHistory("fail", "데이터없음");
                }else{
                    return record;
                }
            }else{
                return new TradeHistory("fail", "계정&세션 불일치");
            }
        }catch (Exception e){
            return new TradeHistory("fail", e.getMessage());
        }
    }

    /**
     * 거래, 출금 수수료 정보
     * */
    @RequestMapping(value = "/selectRateInfo", method = RequestMethod.POST)
    public RateInfo selectRateInfo(@RequestBody RateInfo rateInfo){
        try{
            rateInfo.setKeyValue(1);
            rateInfo = walletService.selectRateInfo(rateInfo);
            rateInfo.setTitle("success");
            rateInfo.setContents("성공");
            return rateInfo;
        }catch (Exception e){
            return new RateInfo("fail", e.getMessage());
        }

    }

    /**
     * 회원대표코인설정
     * */
    @RequestMapping(value = "/updateCoinInfoRep", method = RequestMethod.POST)
    public @ResponseBody Result updateCoinInfoRep(@RequestBody UserCoin userCoin){
        try{
            userCoin.setRepYn("N");
            walletService.updateCoinInfoRep(userCoin);
            userCoin.setRepYn("Y");
            userCoin.setRep(true);
            walletService.updateCoinInfoRep(userCoin);
            return new Result("success", "성공");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }
}
