//import vo.SinhanVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SinhanCardExamTest {

    private static final int [] lenCut = {3, 5, 6, 7, 8, 10, 10, 10, 10, 16};

    public static void main(String [] args){

        String url = "https://api.test.com:8080?abc123akjdfuaihdshfkjdashflkjahdljfhlasdhflasjhfdlhslf23827849278972895fsjdlfjslfslkf";

        List<Map<String, String>> list = new ArrayList<>();
        int startNum=0, sumNum=0;
        String sliceWrod = url.split("\\?")[1];
//        System.out.println(sliceWrod);
//        System.out.println(url.length());
        for(int i=0; i<lenCut.length; i++){
            Map<String, String> map = new HashMap<>();
            sumNum=startNum+lenCut[i];
            map.put(String.valueOf(i), sliceWrod.substring(startNum, sumNum));
            startNum+=lenCut[i];
            list.add(map);
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(i + " : " + list.get(i).get(String.valueOf(i)));
        }



    }

}
