package com.fidelium.rest;

import com.fidelium.api.CryptoCompareApi;
import com.fidelium.domain.CryptoCompare.CoinCurrentCompareVO;
import com.fidelium.domain.TradeHistory;
import com.fidelium.domain.User;
import com.fidelium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017-11-23.
 */

/**
 * 추후에 삭제
 * */
@RestController
@RequestMapping(value = "/noSession")
public class NoSessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private CryptoCompareApi cryptoCompareApi;

    @RequestMapping("/getUserList")
    public @ResponseBody List<User> getUserList(User user) throws Exception{
        return userService.getUserList(user);
    }

    @RequestMapping("/getUser")
    public @ResponseBody User getUser(@RequestBody User user){
        try {
            return userService.getUser(user.getId());
        }catch (Exception e){
            return new User("fail", e.getMessage());
        }
    }

    /**
     * 코인 구매 정보
     * 유저 id, 종류 type, 거래시간 tradeDatetime
     * */
    @RequestMapping(value = "/getCoinCompareInfo", method = RequestMethod.POST)
    public CoinCurrentCompareVO getCoinCompareInfo(@RequestBody CoinCurrentCompareVO coinCurrentCompareVO){
        try {
            return cryptoCompareApi.getCoinInfo(coinCurrentCompareVO);
        }catch (Exception e){
            return new CoinCurrentCompareVO("fail", e.getMessage());
        }
    }

}
