package com.fidelium.rest;

import com.fidelium.domain.AuthenticationRequest;
import com.fidelium.domain.AuthenticationToken;
import com.fidelium.domain.Result;
import com.fidelium.domain.User;
import com.fidelium.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by jin on 17. 10. 9.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    private Authentication authentication;

    /**
     * 회원 로그인
     * */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public AuthenticationToken userLoin(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session){

        String id = authenticationRequest.getId();
        String password = authenticationRequest.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, password);

        try {
            authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new AuthenticationToken("fail", e.getMessage());
        }

        User user = loginService.readUser(id);
        return new AuthenticationToken("success", "로그인 성공", user.getId(), user.getAuthorities(), session.getId());
    }

    /**
     * 관리자 로그인
     * */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public AuthenticationToken adminLogin(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session){

        String id = authenticationRequest.getId();
        String password = authenticationRequest.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, password);

        try {
            authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new AuthenticationToken("fail", e.getMessage());
        }

        User user = loginService.readUser(id);
        return new AuthenticationToken("success", "로그인 성공", user.getId(), user.getAuthorities(), session.getId());
    }

    /**
     * 회원 ID 중복 체크
     * */
    @RequestMapping(value = "/userCheck", method = RequestMethod.POST)
    public Result userCheck(@RequestBody User user){
        try {
            return new Result("success", String.valueOf(loginService.userCheck(user)));
        }catch (Exception e){
            logger.error("{}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
    }

    /**
     * 회원 가입
     * */
    @RequestMapping(value = "/userInsert", method = RequestMethod.POST)
    public Result userInsert(@RequestBody User user){

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
        return new Result("success", "회원가입");
    }

    /**
     * 회원 비밀번호 수정
     * */
    @RequestMapping(value = "/userPassUpdate", method = RequestMethod.POST)
    public Result userPassUpdate(@RequestBody User user){
        /*
        * 핸드폰 번호
        * id(email)
        * 변경할 패스워드
        * */
        try {
            loginService.userPassUpdate(user);
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
        return new Result("success", "회원비밀번호수정");
    }

    /**
     * 회원 정보 수정
     * */
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
     public Result userUpdate(@RequestBody User user){

        try {
            loginService.updateUser(user);
        }catch (Exception e){
            logger.error("error : {}", e.getMessage());
            return new Result("fail", e.getMessage());
        }
        return new Result("success", "회원정보수정");
    }

    /**
     * 로그 아웃
     * */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(HttpSession session) {
        session.invalidate();
        return new Result("success", "로그아웃");
    }

}

