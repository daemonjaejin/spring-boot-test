package com.fidelium.util;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class MessageSourceUtil {

    private static MessageSourceAccessor messageSourceAccessor;

    /**
     * Default Constructor
     */
    private MessageSourceUtil() {
    }

    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        MessageSourceUtil.messageSourceAccessor = messageSourceAccessor;
    }

    /**
     * 코드를 이용하여 메시지 가져오기
     * 
     * @param code
     * @return
     */
    public static final String getMessage(String code) {
        return getMessage(code, null, null);
    }

    /**
     * 코드와 파라미터를 조합하여 메시지 가져오기
     * 
     * @param code
     * @param args
     * @return
     */
    public static final String getMessage(String code, Object[] args) {
        return getMessage(code, args, null);
    }

    /**
     * 요청 언어에 맞는 코드와 파라미터를 조합하여 가져오기
     * 
     * @param code
     * @param args
     * @param locale
     * @return
     */
    public static final String getMessage(String code, Object[] args, Locale locale) {
        return getMessage(code, args, "", locale);
    }

    /**
     * 요청 언어에 맞는 코드와 파라미터를 조합하여 가져오며 만약 없는 경우엔 디폴트 메시지를 가져오기
     * 
     * @param code
     * @param args
     * @param defaultMessage
     * @param locale
     * @return
     */
    public static final String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSourceAccessor.getMessage(code, args, defaultMessage, locale);
    }

}
