package com.fidelium.dao;

import com.fidelium.domain.UserCoin;

import java.util.List;

public interface UserCoinMapper {

    List<UserCoin> userCoinList(UserCoin userCoin);

    UserCoin getUserCoin(UserCoin userCoin);

}