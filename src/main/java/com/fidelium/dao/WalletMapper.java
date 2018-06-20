package com.fidelium.dao;

import com.fidelium.domain.*;

import java.util.List;

/**
 * Created by Administrator on 2017-11-16.
 */
public interface WalletMapper {

    public int insertCoinInfo(CoinInfo coinInfo);

    public int insertUserCoin(UserCoin userCoin);

    public int updateUserCoin(UserCoin userCoin);

    public List<CoinInfo> coinInfoList(CoinInfo coinInfo);

    public List<TradeHistory> selectTradeList(TradeHistory tradeHistory);

    public List<UserTradeHistory> selectUserTradeList(UserTradeHistory userTradeHistory);

    public TradeHistory selectTradeInfo(TradeHistory tradeHistory);

    public int updateRateInfo(RateInfo rateInfo);

    public RateInfo selectRateInfo(RateInfo rateInfo);

    public List<UserTradeHistory> getUserTradeList(UserTradeHistory userTradeHistory);

    public List<TradeHistory> getTradeList(TradeHistory tradeHistory);

    public int updateCoinInfoRep(UserCoin userCoin);

    public int updateCoinInfo(UserCoin userCoin);

}
