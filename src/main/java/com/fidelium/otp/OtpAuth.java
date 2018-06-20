package com.fidelium.otp;

import com.fidelium.domain.User;
import org.apache.commons.codec.binary.Base32;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by jin on 17. 11. 11.
 */
public class OtpAuth{


    /**
     * https://github.com/wstrange/GoogleAuth
     * https://dan.hersam.com/tools/gen-qr-code.html
     * */

    protected Map<String, String> service(User user)
            throws IOException {

        // Allocating the buffer
//      byte[] buffer = new byte[secretSize + numOfScratchCodes * scratchCodeSize];
        byte[] buffer = new byte[5 + 5 * 5];

        // Filling the buffer with random numbers.
        // Notice: you want to reuse the same random generator
        // while generating larger random number sequences.
        new Random().nextBytes(buffer);

        // Getting the key and converting it to Base32
        Base32 codec = new Base32();
//      byte[] secretKey = Arrays.copyOf(buffer, secretSize);
        byte[] secretKey = Arrays.copyOf(buffer, 5);
        byte[] bEncodedKey = codec.encode(secretKey);

        // 생성된 Key!
        String encodedKey = new String(bEncodedKey);

        System.out.println("encodedKey : " + encodedKey);

//      String url = getQRBarcodeURL(userName, hostName, secretKeyStr);
        /**
         * 첫번째 변수 : Label
         * 두번째 변수 : 이메일 ID
         * 세번째 변수 : 이메일 확장자
         * 네번째 변수 encodedKey(OTP 로그인시 입력하는 코드와 같이 사용)
         * */
        String url = getQRBarcodeURL("FIDELIUM", user.getId().split("@")[0], user.getId().split("@")[1], encodedKey); // 생성된 바코드 주소!

        System.out.println("URL : " + url);

        Map<String, String> result = new HashMap<>();
        result.put("encodedKey", encodedKey);
        result.put("url", url);

        return result;
    }

    public static String getQRBarcodeURL(String label, String user, String host, String secret) {
        String format = "https://chart.googleapis.com/chart?cht=qr&chs=150x150&chl=otpauth://totp/%s:%s@%s?secret=%s";
        return String.format(format, label, user, host, secret);
    }

    public static void main(String [] args) throws Exception{
        OtpAuth oa = new OtpAuth();
        User user = new User();
        user.setId("jaejin@test.com");
        Map<String, String> map = oa.service(user);
        System.out.println("url : " + map.get("url"));
        System.out.println("encodedKey : " + map.get("encodedKey"));
    }

}
