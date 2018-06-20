package com.fidelium.rest;

import com.fidelium.domain.*;
import com.fidelium.service.LoginService;
import com.fidelium.service.UserService;
import com.fidelium.service.WalletService;
import com.fidelium.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jin on 17. 11. 19.
 */

@RequestMapping(value = "/admin")
@RestController
public class AdminController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private ExcelUtil excelUtil;

    /**
     * 회원 정보 리스트
     * */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    public @ResponseBody Result getUserList(@RequestBody User user){
        try {
            Result result = new Result();
            result.setUserList(userService.getUserList(user));
            user.setCount(true);
            result.setTotalNum(userService.getUserList(user).get(0).getTotalNum());
            result.setTitle("success");
            result.setContents("회원정보리스트");
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 회원 정보 엑셀 리스트
     * */
    @RequestMapping(value = "/getUserListExcel", method = RequestMethod.GET)
    public ModelAndView getUserListExcel(@RequestBody User user, HttpServletResponse response) throws Exception{
        List<String> headerNames = Arrays.asList("ID(E-mail)", "Name", "Level", "National", "ETC");
        List<String> headers = Arrays.asList("id", "name", "level", "nation", "etc");
        List<User> list = userService.getUserList(user);
        excelUtil.createExcelOutputExcel(response, list, headerNames, headers, "user.xls", "userInfo");
        return null;
    }

    /**
     * 관리자에서 회원 추가
     * */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        try {
            user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
            if(loginService.userCheck(user) == 0){
                loginService.createUser(user);
            }else{
                return new Result("fail", "ID 중복");
            }
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
        return new Result("success", "관리자가입");
    }

    /**
     * 관리자 ID 중복 체크
     * */
    @RequestMapping(value = "/adminCheck", method = RequestMethod.POST)
    public Result userCheck(@RequestBody User user){
        try {
            return new Result("success", String.valueOf(loginService.userCheck(user)));
        }catch (Exception e){
            logger.error("{}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 관리자 등록
     * */
    @RequestMapping(value = "/adminInsert", method = RequestMethod.POST)
    public Result userInsert(@RequestBody User user){

        try {
            user.setAuthorities(AuthorityUtils.createAuthorityList("ADMIN"));
            if(loginService.userCheck(user) == 0){
                loginService.createUser(user);
            }else{
                return new Result("fail", "ID 중복");
            }
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
        return new Result("success", "관리자가입");
    }

    /**
     * 회원/관리자 정보 수정
     * */
    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public @ResponseBody User updateAdmin(@RequestBody User user){
        try {
            loginService.updateUser(user);
            user.setTitle("success");
            user.setContents("성공");
        }catch (Exception e){
            return new User("fail", e.getMessage());
        }
        return user;
    }

    /**
     * 관리자 비밀번호 수정
     * */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public @ResponseBody Result updatePassword(@RequestBody User user){
        try {
            String oriPassword = user.getPassword();
            String encodedPassword = new BCryptPasswordEncoder().encode(oriPassword);
            user.setOriPassword(oriPassword);
            user.setPassword(encodedPassword);
            loginService.updateUser(user);
            return new Result("success", "비밀번호변경");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 관리자 정보
     * */
    @RequestMapping(value = "/adminInfo", method = RequestMethod.POST)
    public User userInfo(@RequestBody User user){
        User userResult = loginService.readUser(user.getId());
        userResult.setTitle("success");
        userResult.setContents("관리자정보");
        return userResult;
    }

    /**
     * 관리자 리스트
     * */
    @RequestMapping(value = "/adminList", method = RequestMethod.POST)
    public @ResponseBody Result adminList(@RequestBody User user){
        try {
            Result result = new Result();
            result.setList(userService.getUserList(user));
            result.setUserList(userService.getUserList(user));
            user.setCount(true);
            result.setTotalNum(userService.getUserList(user).get(0).getTotalNum());
            result.setTitle("success");
            result.setContents("회원정보리스트");
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 지갑 리스트
     * */
    @RequestMapping(value = "/walletList", method = RequestMethod.POST)
    public @ResponseBody Result walletList(@RequestBody CoinInfo coinInfo){
        try {
            Result result = new Result();
            result.setCoinInfoList(walletService.coinInfoList(coinInfo));
            coinInfo.setCount(true);
            result.setTotalNum(walletService.coinInfoList(coinInfo).get(0).getTotalNum());
            result.setTitle("success");
            result.setContents("지갑리스트");
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * Send, Receive 리스트
     * */
    @RequestMapping(value = "/getUserTradeList", method = RequestMethod.POST)
    public @ResponseBody Result getUserTradeHistoryList(@RequestBody UserTradeHistory userTradeHistory){
        try {
            Result result = new Result();
            result.setUserTradeHistoryList(walletService.getUserTradeList(userTradeHistory));
            userTradeHistory.setCount(true);
            result.setTotalNum(walletService.getUserTradeList(userTradeHistory).get(0).getTotalNum());
            result.setTitle("success");
            result.setContents("Send,Receive리스트");
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 거래(Trade) 리스트
     * */
    @RequestMapping(value = "/getTradeList", method = RequestMethod.POST)
    public @ResponseBody Result selectTradeList(@RequestBody TradeHistory tradeHistory){
        try {
            Result result = new Result();
            result.setTradeHistoryList(walletService.getTradeList(tradeHistory));
            tradeHistory.setCount(true);
            result.setTotalNum(walletService.getTradeList(tradeHistory).get(0).getTotalNum());
            result.setTitle("success");
            result.setContents("거래리스트");
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 회원 인증 요청 정보
     * */
    @RequestMapping(value = "/getUserConfirmList", method = RequestMethod.POST)
    public @ResponseBody User getUserConfirmList(@RequestBody User user){
        try {
            return userService.getUserConfirmList(user);
        }catch (Exception e){
            return new User("fail", e.getMessage());
        }
    }

    /**
     * 출금수수료, 거래수수료 일괄 변경
     * */
    @RequestMapping(value = "/updateRateInfo", method = RequestMethod.POST)
    public @ResponseBody Result updateRateInfo(@RequestBody RateInfo rateInfo){
        try {
            walletService.updateRateInfo(rateInfo);
            return new Result("success", "성공");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 유저 코인정보 가지고 오기
     * */
    @RequestMapping(value = "/userCoinList", method = RequestMethod.POST)
    public @ResponseBody Result userCoinList(@RequestBody UserCoin userCoin){
        try {
            Result result = new Result();
            result.setTitle("success");
            result.setContents("성공");
            result.setList(walletService.userCoinList(userCoin));
            return result;
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 유저 코인정보 수정
     * */
    @RequestMapping(value = "/updateCoinInfo", method = RequestMethod.POST)
    public @ResponseBody Result updateCoinInfo(@RequestBody UserCoin userCoin){
        try {
            walletService.updateCoinInfo(userCoin);
            return new Result("success", "성공");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }
}
