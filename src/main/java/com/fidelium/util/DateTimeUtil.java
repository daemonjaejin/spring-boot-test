package com.fidelium.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * date & time 유틸리티 <br/>
 * 
 * @author
 */
public class DateTimeUtil {

    /**
     * date {@value} 형 패턴
     */
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * datetime {@value} 형 패턴
     */
    public static final String SIMPLE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * datetime {@value} 형 패턴
     */
    public static final String TIMESTAMP_PATTERN = "yyyyMMddHHmmss";

    /**
     * date {@value} 형 패턴
     */
    public static final String DIRECTORY_DATE_FORMAT = "yyyy/MM/dd";

    /**
     * date {@value} 형 패턴
     */
    public static final String DIRECTORY_DATE_FORMAT2 = "yyyy/MM";

    /**
     * date {@value} 형 패턴
     */
    public static final String SIMPLE_DATE_PATTERN = "yyyyMMdd";

    /**
     * datetime {@value} 형 패턴
     */
    public static final String MAINTAINANCE_DATE_FORMAT = "yy-MM-dd HH:mm";

    /**
     * Default Constructor
     */
    private DateTimeUtil() {
    }

    /**
     * yyyy-MM-dd 형태로 오늘의 날짜 가져오기
     * 
     * @return yyyy-MM-dd 형태의 문자열
     */
    public static final String getToday() {
        return getToday(SHORT_DATE_FORMAT);
    }

    /**
     * pattern 의 형태로 오늘 날짜 가져오기
     * 
     * @param pattern
     * @return
     */
    public static final String getToday(String pattern) {
        return getDateToString(null, pattern);
    }

    /**
     * @return 현재시간을 "yyyyMMddHHmmss" 형식으로 리턴
     */
    public static final long getTimeLong(int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, i);
        return cal.getTime().getTime();
    }

    /**
     * @return 현재시간을 "yyyyMMddHHmmss" 형식으로 리턴
     */
    public static final String getTimestamp() {
        String now = getDateToString(0, TIMESTAMP_PATTERN);
        return now;
    }

    /**
     * 현재 시간 <code>long</code> 형을 문자열로 변환
     * 
     * @param timestamp
     * @param pattern
     * @return
     */
    public static final String getDateToString(final long timestamp, final String pattern) {
        long current = timestamp;
        String datePattern = pattern;
        if (current == 0) {
            current = System.currentTimeMillis();
        }
        if (datePattern == null || "".equals(datePattern)) {
            datePattern = SIMPLE_PATTERN;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(datePattern);
        return fmt.format(new Date(current));
    }

    /**
     * 날짜 <code>date</code> 형을 문자열로 변환
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static final String getDateToString(final Date date, final String pattern) {
        String dateFormat = null;
        Date simpleDate = null;
        if (date == null) {
            simpleDate = new Date();
        } else {
            simpleDate = date;
        }
        if (pattern == null || "".equals(pattern)) {
            dateFormat = SIMPLE_PATTERN;
        } else {
            dateFormat = pattern;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
        return fmt.format(simpleDate);
    }

    public static final String getDateToString() {
        return getDateToString(new Date(), SIMPLE_PATTERN);
    }

    public static final Date parseStringToDate(final String dateStr, final String pattern) throws ParseException {
        String dateFormat = null;
        if (pattern == null || "".equals(pattern)) {
            dateFormat = SIMPLE_PATTERN;
        } else {
            dateFormat = pattern;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
        return fmt.parse(dateStr);
    }

    /**
     * 기준일 비교
     * 
     * @param std
     * @param dateStr
     * @return
     */
    public static final boolean isDateValid(int std, String dateStr, String pattern) {
        Date lastDate = null;
        try {
            lastDate = parseStringToDate(dateStr, pattern);
        } catch (ParseException e) {
            lastDate = null;
        }
        return lastDate == null ? false : isDateValid(std, lastDate);
    }

    public static final boolean isDateValid(int std, String dateStr) {
        return isDateValid(std, dateStr, TIMESTAMP_PATTERN);
    }

    /**
     * 기준일 비교
     * 
     * @param std
     * @param dateStr
     * @return
     */
    public static final boolean isDateValid(int std, Date lastDate) {
        boolean flag = false;
        long lastTime = lastDate.getTime();
        long limit = addDate(-std).getTime();
        if (lastTime >= limit)
            flag = true;
        return flag;
    }

    /**
     * 날짜 계산 구하기
     * 
     * @param day
     *            계산할 날짜
     * @return 더한 날짜 구하기
     */
    public static final Date addDate(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    public static final String addDateAsString(int day, String format) {
        Date date = addDate(day);
        return getDateToString(date, format);
    }

    /**
     * 시간 계산
     * */
    public static final long compareStringToDate(String strDate){
        SimpleDateFormat f = new SimpleDateFormat(TIMESTAMP_PATTERN);
        long l = 0L;
        try {
            Date d = f.parse(strDate);
            l = d.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return l;
    }

}
