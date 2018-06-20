import com.fidelium.App;
import com.fidelium.domain.User;
import com.fidelium.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class UserMapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void readUserTest(){
        User user = userService.getUser("test");
        System.out.println(user.getId());
        List<GrantedAuthority> authorities = userService.readAuthority("test");
        for (GrantedAuthority grantedAuthority : authorities){
            System.out.println(grantedAuthority.getAuthority());
        }
    }

}
