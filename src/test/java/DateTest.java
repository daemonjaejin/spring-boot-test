import com.fidelium.domain.LombokVO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-11-15.
 */
public class DateTest {

    private static long L = 1510727537000L;

    public static void main(String [] args){
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(L);
        System.out.println(dateString);
        //System.out.println(builderTest().getDate());
    }

    public static LombokVO builderTest(){
        //LombokVO lombokVO = LombokVO.builder().date(new Date()).build();
//        testVo.setDate(new Date());
        //return lombokVO;
    		return null;
    }

}
