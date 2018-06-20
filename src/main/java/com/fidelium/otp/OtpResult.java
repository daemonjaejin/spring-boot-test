package com.fidelium.otp;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


import org.apache.commons.codec.binary.Base32;

/**
 * Created by jin on 17. 11. 11.
 */
public class OtpResult {

    protected void service(String encodedKey, String code)
            throws IOException {

        DateFormat df = new SimpleDateFormat("YYYYMMdd-HH:mm:ss");

        long user_code = Integer.parseInt(code);
        long l = new Date().getTime();
        System.out.println(l);
        System.out.println(df.format(l));
        System.out.println(df.format(l-30000));
        System.out.println(df.format(l/30000));
        long ll =  l / 30000;
        long ttt = TimeUnit.SECONDS.toMillis(30);
        System.out.println("ttt : " + ttt);
        System.out.println("ttt2 : " + df.format(ttt));
        System.out.println("ttt3 : " + df.format(l/ttt));
//        long ll =  l - 30000;
        System.out.println(ll);
        System.out.println(df.format(ll));

        boolean check_code = false;
        try {
            // 키, 코드, 시간으로 일회용 비밀번호가 맞는지 일치 여부 확인.
            check_code = check_code(encodedKey, user_code, ll);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 일치한다면 true.
        System.out.println("check_code : " + check_code);

    }

    private static boolean check_code(String secret, long code, long t) throws NoSuchAlgorithmException, InvalidKeyException {
        Base32 codec = new Base32();
        byte[] decodedKey = codec.decode(secret);

        // Window is used to check codes generated in the near past.
        // You can use this value to tune how far you're willing to go.
        int window = 3;
        for (int i = -window; i <= window; ++i) {
            long hash = verify_code(decodedKey, t + i);

            if (hash == code) {
                return true;
            }
        }

        // The validation code is invalid.
        return false;
    }

    private static int verify_code(byte[] key, long t)
            throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }

        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);

        int offset = hash[20 - 1] & 0xF;

        // We're using a long because Java hasn't got unsigned int.
        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) {
            truncatedHash <<= 8;
            // We are dealing with signed bytes:
            // we just keep the first byte.
            truncatedHash |= (hash[offset + i] & 0xFF);
        }

        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;

        return (int) truncatedHash;
    }

    public static void main(String [] args) throws Exception{
        OtpResult otp = new OtpResult();
        otp.service("4BLJYMQS", "113665");
    }

}
