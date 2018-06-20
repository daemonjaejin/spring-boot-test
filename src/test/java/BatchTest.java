import com.fidelium.App;
import com.fidelium.dao.MmsMapper;
import com.fidelium.domain.Message.MmsAuthToken;
import com.fidelium.domain.Message.MmsSendVO;
import com.fidelium.service.MmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Administrator on 2017-11-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class BatchTest {

    @Autowired
    private MmsService mmsService;

    @Autowired
    private MmsMapper mmsMapper;

    @Test
    public void test(){
//        MmsAuthToken mmsAuthToken = mmsService.authSend();
//        System.out.println(mmsAuthToken.toString());
//        MmsSendVO mmsSendVO = new MmsSendVO();
//        mmsSendVO.setTo("821025810627");
//        mmsService.messageSend(mmsSendVO);

        MmsSendVO mmsSendVO = new MmsSendVO();
        mmsSendVO.setTo("821025810627");
        mmsSendVO.setGroupId("20171201180407703A0218850003");
        mmsSendVO.setToCount("1");
        mmsSendVO.setMessageId("20171201180407703A0218850003-0");
        mmsSendVO.setStatus("R000");
        mmsSendVO.setErrorText("");
        mmsMapper.insertMmsSendResult(mmsSendVO);

    }

}
