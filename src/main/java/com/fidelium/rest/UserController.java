package com.fidelium.rest;

import com.fidelium.domain.Board;
import com.fidelium.domain.Result;
import com.fidelium.domain.User;
import com.fidelium.otp.GoogleOtp;
import com.fidelium.service.LoginService;
import com.fidelium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jin on 17. 10. 22.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/updateUser")
    public @ResponseBody Result updateUser(@RequestBody User user){
        try {
            loginService.updateUser(user);
            return new Result("success", "회원정보수정");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    @RequestMapping("/updatePassword")
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

    @RequestMapping("/updateAuthPassword")
    public @ResponseBody Result updateAuthPassword(@RequestBody User user){
        try {
            loginService.updateUser(user);
            return new Result("success", "보안비밀번호변경");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    @RequestMapping("/insertBoard")
    public @ResponseBody Result insertBoard(@RequestBody Board board){
        try {
            userService.insertBoard(board);
            return new Result("success", "질의성공");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * auth_password(2차 비밀번호)
     * OTP 인증
     * */
    @RequestMapping("/authConfirm")
    public @ResponseBody Result authConfirm(@RequestBody User user){
        try {
            User record = userService.getUser(user.getId());
            if(!record.getAuthPassword().equals(user.getAuthPassword())){
                return new Result("fail", "2차 비밀번호 틀림");
            }
            if(!GoogleOtp.otpAuth(record.getOtpQrKey(), Integer.parseInt(user.getOtpPassword()))){
                return new Result("fail", "OTP 비밀번호 틀림");
            }
            return new Result("success", "인증성공");
        }catch (Exception e){
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 회원정보
     * */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public User userInfo(@RequestBody User user){
        User userResult = loginService.readUser(user.getId());
        userResult.setTitle("success");
        userResult.setContents("회원정보");
        return userResult;
    }

}
