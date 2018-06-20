import com.fasterxml.jackson.databind.ObjectMapper;
import com.fidelium.App;
import com.fidelium.domain.AuthenticationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;



/**
 * Created by Administrator on 2017-10-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void loginTest() throws Exception{
        AuthenticationRequest request = new AuthenticationRequest();
        request.setId("1508834256642");
        request.setPassword("1508834256642");

        ObjectMapper om = new ObjectMapper();

        mvc.perform(
                post("/login/user")
                .contentType(MediaType.APPLICATION_JSON+";charset=UTF-8")
                .content(om.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON+";charset=UTF-8"))
                .andExpect(jsonPath("$.id", is(request.getId().toUpperCase())))
                .andExpect(jsonPath("$.authorities[*].authority", hasItem("USER"))) ;

    }

}
