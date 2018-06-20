import com.fidelium.App;
import com.fidelium.domain.User;
import com.fidelium.service.LoginService;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2017-12-13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class FileTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void test() throws Exception{
        User user = new User();
        File newFile = new File("C:\\data\\Chrysanthemum.jpg");
        FileInputStream input = new FileInputStream(newFile);
        MultipartFile file = new MockMultipartFile("file", newFile.getName(), "text/plain", IOUtils.toByteArray(input));
        MultipartFile[] files = { file };
        user.setFiles(files);
        loginService.updateUser(user);
    }

}
