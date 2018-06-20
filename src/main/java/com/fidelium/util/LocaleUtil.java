package com.fidelium.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

public class LocaleUtil {

    /**
     * Default Constructor
     */
    private LocaleUtil() {
    }

    /**
     * 시스템 정책에 따라서 현재 로케일 정보를 리턴 한다. <br />
     * getLocaleService().getCurrentLocale(request);
     *
     * @param request
     *            HttpServletRequest
     * @return Locale 시스템 정책에 맞는 로케일 오브젝트 리턴
     * @throws Exception
     *             the exception
     * @since 2015. 12. 18.
     */
    public static final Locale getCurrentLocale(HttpServletRequest request) {
        return RequestContextUtils.getLocale(request);
    }

    /**
     * 쓰레드 로컬에 저장된 현재 HttpServletRequest 객체를 얻는다.
     * 
     * @return
     */
    public static final Locale getCurrentLocale() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return RequestContextUtils.getLocale(request);
    }

}
