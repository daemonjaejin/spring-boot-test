package com.fidelium.dao;

import com.fidelium.domain.CoinInfo;

public interface CoinInfoMapper {
    int insert(CoinInfo record);
    CoinInfo getCoinInfo(CoinInfo coinInfo);
}