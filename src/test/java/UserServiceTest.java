import com.fidelium.App;
import com.fidelium.domain.User;
import com.fidelium.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Administrator on 2017-10-24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private LoginService loginService;

    private User user1;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setup(){
        long longs = System.currentTimeMillis();
        user1 = new User();
        user1.setId(String.valueOf(longs));
        user1.setPassword(String.valueOf(longs));
        user1.setName(String.valueOf(longs));
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setCredentialsNonExpired(true);
        user1.setEnabled(true);
        //user1.setAuthorities(AuthorityUtils.createAuthorityList("USER", "ADMIN"));
        user1.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
    }

    @Test
    public void createUserTest(){

        loginService.realDeleteUser(user1.getId());

        logger.info("user1.toString() : {}", user1.toString());
        logger.info("user1.getAuthorities() : {}", user1.getAuthorities());

        loginService.createUser(user1);
        User user = loginService.readUser(user1.getId());
        logger.info("id : {}", user.getId());

        PasswordEncoder passwordEncoder = loginService.passwordEncoder();
        logger.info("isPassword : {}", passwordEncoder.matches("test1", user.getPassword()));

        Collection<? extends GrantedAuthority> authorities1 = user1.getAuthorities();
        Iterator<? extends GrantedAuthority> it = authorities1.iterator();
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();

        while (it.hasNext()){
            GrantedAuthority authority = it.next();
            logger.info("authority : {}", new SimpleGrantedAuthority(authority.getAuthority()));
            logger.info("authorities : {}", authorities);
        }

    }

}
