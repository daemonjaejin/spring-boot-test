package com.fidelium.service;

import com.fidelium.dao.CoinInfoMapper;
import com.fidelium.dao.UserCoinMapper;
import com.fidelium.dao.WalletMapper;
import com.fidelium.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017-11-16.
 */

@Service
@Transactional
public class WalletService {

    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private CoinInfoMapper coinInfoMapper;

    @Autowired
    private UserCoinMapper userCoinMapper;

    /**
     * 코인 정보 가지고 오기
     * */
    public CoinInfo getCoinInfo(CoinInfo coinInfo){
        return coinInfoMapper.getCoinInfo(coinInfo);
    }

    /**
     * 코인 정보 등록
     * */
    public int insertCoinInfo(CoinInfo coinInfo){
        return walletMapper.insertCoinInfo(coinInfo);
    }

    /**
     * 코인 리스트
     * */
    public List<CoinInfo> coinInfoList(CoinInfo coinInfo){
        return walletMapper.coinInfoList(coinInfo);
    }

    /**
     * 유저 코인 등록
     * */
    public int insertUserCoin(UserCoin userCoin){
        return walletMapper.insertUserCoin(userCoin);
    }

    /**
     * 유저 코인 업데이트
     * */
    public int updateUserCoin(UserCoin userCoin){
        return walletMapper.updateUserCoin(userCoin);
    }

    /**
     * 유저 코인 업데이트
     * */
    public int userCoinUpdate(UserCoin userCoin){
        return walletMapper.updateUserCoin(userCoin);
    }

    /**
     * 유저 코인 정보 조회
     * */
    public UserCoin getUserCoin(UserCoin userCoin){
        return userCoinMapper.getUserCoin(userCoin);
    }

    /**
     * 유저 코인 리스트 조회
     * */
    public List<UserCoin> userCoinList(UserCoin userCoin){
        return userCoinMapper.userCoinList(userCoin);
    }

    /**
     * 거래소
     * */
    public List<TradeHistory> selectTradeList(TradeHistory tradeHistory){
        return walletMapper.selectTradeList(tradeHistory);
    }

    /**
     * 유저 거래 정보 조회
     * */
    public TradeHistory selectTradeInfo(TradeHistory tradeHistory){
        return walletMapper.selectTradeInfo(tradeHistory);
    }

    /**
     * 유저 거래 리스트 조회
     * */
    public List<UserTradeHistory> selectUserTradeList(UserTradeHistory userTradeHistory){
        return walletMapper.selectUserTradeList(userTradeHistory);
    }

    /**
     * 출금, 거래 수수료 업데이트
     * */
    public int updateRateInfo(RateInfo rateInfo){
        rateInfo.setKeyValue(1);
        return walletMapper.updateRateInfo(rateInfo);
    }

    /**
     * 거래, 출금 수수료 정보
     * */
    public RateInfo selectRateInfo(RateInfo rateInfo){
        return walletMapper.selectRateInfo(rateInfo);
    }

    /**
     * 관리자화면
     * 유저간 send, receive 리스트
     * */
    public List<UserTradeHistory> getUserTradeList(UserTradeHistory userTradeHistory){
        return walletMapper.getUserTradeList(userTradeHistory);
    }

    /**
     * 관리자화면
     * 거래 리스트
     * */
    public List<TradeHistory> getTradeList(TradeHistory tradeHistory){
        return walletMapper.getTradeList(tradeHistory);
    }

    /**
     * 관리자 화면
     * 코인정보 대표 업데이트
     * */
    public int updateCoinInfoRep(UserCoin userCoin){
        return walletMapper.updateCoinInfoRep(userCoin);
    }

    /**
     * 관리자 화면
     * 코인정보 업데이트
     * */
    public int updateCoinInfo(UserCoin userCoin){
        return walletMapper.updateCoinInfo(userCoin);
    }

}
