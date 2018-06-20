package com.fidelium.otp;

import com.fidelium.domain.User;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jin on 17. 11. 11.
 */
public class GoogleOtp{

    protected static final String LABEL = "FIDELIUM";

    private static final Logger logger = LoggerFactory.getLogger(GoogleOtp.class);

    /**
     * 구글 otp encoded Key 생성
     * */
    public static String otpIdCreate(){
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        String encoded = key.getKey();
        logger.info("{}", encoded);
        return encoded;
    }

    /**
     * 구글 otp 인증
     * */
    public static boolean otpAuth(String secretKey, int password){
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean result = gAuth.authorize(secretKey, password);
        logger.info("{}", result);
        return result;
    }

    /**
     * 구글 otp 생성 코드
     * */
    public static int otpCodeCreate(String secretKey){
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        int code = gAuth.getTotpPassword(secretKey);
        logger.info("{}", code);
        return code;
    }

    public static String getQRBarcodeURL(String label, String user, String host, String secret) {
        String format = "https://chart.googleapis.com/chart?cht=qr&chs=150x150&chl=otpauth://totp/%s:%s@%s?secret=%s";
        String result = String.format(format, label, user, host, secret);
        logger.info("{}", result);
        return result;
    }


    public static void main(String [] args){
        User user = new User();
        user.setId("test@company.com");

        /**
         * encoded key 생성 및 QR 코드 생성
         *  생성 계정키 : ASF55PIO3WW5NLSW
         *  url : https://chart.googleapis.com/chart?cht=qr&chs=150x150&chl=otpauth://totp/FIDELIUM:jaejin@test@company?secret=ASF55PIO3WW5NLSW
         * */

//         getQRBarcodeURL(LABEL, user.getId().split("@")[0], user.getId().split("@")[1], otpIdCreate());

        /**
         * OTP 코드 인증(이전과 현재만 가능)
         * 485635(485635) -> 211410(485635) -> 711353()
         * */

//        otpAuth("ASF55PIO3WW5NLSW", 485635);

        /**
         * OTP 앱 없이 코드 보여주기
         * */
//        otpCodeCreate("ASF55PIO3WW5NLSW");

    }


}
