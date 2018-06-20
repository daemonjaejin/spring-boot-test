import com.fidelium.App;
import com.fidelium.api.BlockCypherApi;
import com.fidelium.domain.CoinInfo;
import com.fidelium.proto.CryptoProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class BlockCypherTest {

	@Autowired
	private BlockCypherApi blockCypherService;

    @Autowired
    private CryptoProperties properties;
	
	@Test
	public void test() {
        CoinInfo coinInfo = new CoinInfo();
        coinInfo.setId(String.valueOf(System.currentTimeMillis()));
		blockCypherService.createWalletProccess(coinInfo);
        for (String str : properties.getCoinList()){
            System.out.println("str : " + str);
        }
	}
	
}
