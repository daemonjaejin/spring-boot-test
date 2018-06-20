package com.fidelium.util;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    /** The Constant HTML_TAG. */
    static final Pattern HTML_TAG = Pattern.compile("\\<.*?\\>", 2);

    /**
     * The Hex chars.
     */
    private static final String[] hexChars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

    /**
     * FORMAT_DOUBLE
     */
    static final String FORMAT_DOUBLE = "###,###.##";

    /**
     * FORMAT_INTEGER
     */
    static final String FORMAT_INTEGER = "###,###";

    /**
     * Default Constructor
     */
    private StringUtil() {
    }

    /**
     * 설정된 포맷으로 숫자를 스트링 형태로 리턴 한다. <br />
     * getStringService().numberToString(10000, "###,###");
     *
     * @param number
     *            변환될 수
     * @param format
     *            포맷
     * @return String 변환된 스트링
     */
    public static String numberToString(Long number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    /**
     * 설정된 포맷으로 숫자를 스트링 형태로 리턴 한다. <br />
     * getStringService().doubleToString(10000.00) = 10,000.00
     *
     * @param number
     *            변환될 수
     * @return String 변환된 스트링
     */
    public static String doubleToString(Double number) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_DOUBLE);
        return decimalFormat.format(number);
    }

    /**
     * 설정된 포맷으로 숫자를 스트링 형태로 리턴 한다. <br />
     * getStringService().integerToString(10000) = 10,000
     *
     * @param number
     *            변환될 수
     * @return String 변환된 스트링
     */
    public static String integerToString(Integer number) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_INTEGER);
        return decimalFormat.format(number);
    }

    /**
     * 설정된 포맷으로 숫자를 스트링 형태로 리턴 한다. <br />
     * getStringService().longToString(10000) = 10,000
     *
     * @param number
     *            변환될 수
     * @return String 변환된 스트링
     */
    public static String longToString(Long number) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_INTEGER);
        return decimalFormat.format(number);
    }

    /**
     * String이라고 예상되어있는 값이 null( ""이 아님)로 들어 왔을 경우에 대체를 해주는 함수. <br />
     * getStringService().nvl(null,"xxx") = "xxx"<br/>
     *
     * @param value
     *            null인지 확인을 해야 하는 대상
     * @param replacer
     *            null일 경우에 대체될 값
     * @return String value가 null이 아닐경우에는 value, null일경우에는 replacer가 반환됨
     */
    public static String nvl(final String value, final String replacer) {
        if (value == null) {
            return replacer;
        } else {
            return value;
        }
    }

    /**
     * 스트링 값이 null 또는 "" 일 경우 true를 리턴 한다. <br />
     * getStringService().isEmpty(null) <br/>
     * getStringService().isEmpty("") <br/>
     *
     * @param value
     *            검증 대상 스트링
     * @return true:값이 없을 경우, false:값이 존재할 경우
     */
    public static boolean isEmpty(String value) {
        return StringUtils.isEmpty(value);
    }

    /**
     * 스트링 값이 null 또는 "" 아닐 경우 true를 리턴 한다. <br />
     * getStringService().isEmpty(null) <br/>
     * getStringService().isEmpty("") <br/>
     *
     * @param value
     *            검증 대상 스트링
     * @return true:값이 없을 경우, false:값이 존재할 경우
     */
    public static boolean isNotEmpty(String value) {
        return !StringUtils.isEmpty(value);
    }

    /**
     * 기본 trim 처리를 하고 null 또는 값이 없을 경우 "" 스트링으로 치환 한다. <br />
     * getStringService().trimToEmpty(null) = "" <br/>
     * getStringService().trimToEmpty("") = "" <br/>
     * getStringService().trimToEmpty(" ") = "" <br/>
     * getStringService().trimToEmpty("abc") = "abc" <br/>
     * getStringService().trimToEmpty(" abc ") = "abc" <br/>
     *
     * @param value
     *            검증 대상 스트링
     * @return String trim 처리가 완료된 스트링
     */
    public static String trimToEmpty(String value) {
        return StringUtils.trimToEmpty(value);
    }

    /**
     * 대소문자 구분 없이 값을 비교 한다. <br />
     * getStringService().equalsIgnoreCase(null, null) = true<br/>
     * getStringService().equalsIgnoreCase(null, "abc") = false<br/>
     * getStringService().equalsIgnoreCase("abc", null) = false<br/>
     * getStringService().equalsIgnoreCase("abc", "abc") = true<br/>
     * getStringService().equalsIgnoreCase("abc", "ABC") = true<br/>
     *
     * @param source
     *            검증 대상 소스 스트링
     * @param target
     *            검증 대상 타켓 스트링
     * @return true:같이 같은 경우, false:값이 다른 경우
     */
    public static boolean equalsIgnoreCase(String source, String target) {
        return StringUtils.equalsIgnoreCase(source, target);
    }

    /**
     * 대소문자 구분 하고 값 포함 유무를 체크 한다. <br />
     *
     * getStringService().contains(null, *) = false<br/>
     * getStringService().contains(*, null) = false<br/>
     * getStringService().contains("", "") = true<br/>
     * getStringService().contains("abc", "") = true<br/>
     * getStringService().contains("abc", "a") = true<br/>
     * getStringService().contains("abc", "z") = false<br/>
     *
     * @param source
     *            검증 대상 소스 스트링
     * @param target
     *            검증 대상 타켓 스트링
     * @return true:포함 될 경우, false:포함 되지 않을 경우
     */
    public static boolean contains(String source, String target) {
        return StringUtils.contains(source, target);
    }

    /**
     * 대소문자 구분 없이 값 포함 유무를 체크 한다. <br />
     * getStringService().contains(null, *) = false<br/>
     * getStringService().contains(*, null) = false<br/>
     * getStringService().contains("", "") = true<br/>
     * getStringService().contains("abc", "") = true<br/>
     * getStringService().contains("abc", "a") = true<br/>
     * getStringService().contains("abc", "z") = false<br/>
     * getStringService().contains("abc", "A") = true<br/>
     * getStringService().contains("abc", "Z") = false<br/>
     *
     * @param source
     *            검증 대상 소스 스트링
     * @param target
     *            검증 대상 타켓 스트링
     * @return true:포함 될 경우, false:포함 되지 않을 경우
     */
    public static boolean containsIgnoreCase(String source, String target) {
        return StringUtils.containsIgnoreCase(source, target);
    }

    /**
     * indexOf 메서드 와 동일하다 대신 검색 스트링을 Array로 설정 할 수 있다. <br />
     * getStringService().indexOfAny(null, *) = -1<br/>
     * getStringService().indexOfAny("", *) = -1<br/>
     * getStringService().indexOfAny(*, null) = -1<br/>
     * getStringService().indexOfAny(*, []) = -1<br/>
     * getStringService().indexOfAny("zzabyycdxx",['z','a']) = 0<br/>
     * getStringService().indexOfAny("zzabyycdxx",['b','y']) = 3<br/>
     * getStringService().indexOfAny("aba", ['z']) = -1<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param searchChars
     *            검색어 배열
     * @return Int 검색된 위치
     */
    public static int indexOfAny(String value, char... searchChars) {
        return StringUtils.indexOfAny(value, searchChars);
    }

    /**
     * indexOf 메서드 와 동일하다 대신 연속된 검색어를 설정 할 수 있다. <br />
     * getStringService().indexOfAny(null, *) = -1<br/>
     * getStringService().indexOfAny("", *) = -1<br/>
     * getStringService().indexOfAny(*, null) = -1<br/>
     * getStringService().indexOfAny(*, "") = -1<br/>
     * getStringService().indexOfAny("zzabyycdxx", "za") = 0<br/>
     * getStringService().indexOfAny("zzabyycdxx", "by") = 3<br/>
     * getStringService().indexOfAny("aba","z") = -1<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param searchChars
     *            연속된 스트링 검색어
     * @return Int 검색된 위치
     */
    public static int indexOfAny(String value, String searchChars) {
        return StringUtils.indexOfAny(value, searchChars);
    }

    /**
     * String.substring 기능 + 범위를 벗어날 경우 "" 값으로 리턴 한다. <br />
     * getStringService().substring(null, *, *) = null<br/>
     * getStringService().substring("", * , *) = "";<br/>
     * getStringService().substring("abc", 0, 2) = "ab"<br/>
     * getStringService().substring("abc", 2, 0) = ""<br/>
     * getStringService().substring("abc", 2, 4) = "c"<br/>
     * getStringService().substring("abc", 4, 6) = ""<br/>
     * getStringService().substring("abc", 2, 2) = ""<br/>
     * getStringService().substring("abc", -2, -1) = "b"<br/>
     * getStringService().substring("abc", -4, 2) = "ab"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param start
     *            시작 index
     * @param end
     *            마지막 index
     * @return String 검색된 스트링
     */
    public static String substring(String value, int start, int end) {
        return StringUtils.substring(value, start, end);
    }

    /**
     * 스트링 왼쪽 부터 지정된 숫자까지 스트링을 리턴 한다. <br />
     * getStringService().left(null, *) = null<br/>
     * getStringService().left(*, -ve) = ""<br/>
     * getStringService().left("", *) = ""<br/>
     * getStringService().left("abc", 0) = ""<br/>
     * getStringService().left("abc", 2) = "ab"<br/>
     * getStringService().left("abc", 4) = "abc"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param len
     *            검색 길이
     * @return String String 검색된 스트링
     */
    public static String left(String value, int len) {
        return StringUtils.left(value, len);
    }

    /**
     * 스트링 오른쪽 부터 지정된 숫자까지 스트링을 리턴 한다. <br />
     * getStringService().right(null, *) = null<br/>
     * getStringService().right(*, -ve) = ""<br/>
     * getStringService().right("", *) = ""<br/>
     * getStringService().right("abc", 0) = ""<br/>
     * getStringService().right("abc", 2) = "bc"<br/>
     * getStringService().right("abc", 4) = "abc"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param len
     *            검색 길이
     * @return String String 검색된 스트링
     */
    public static String right(String value, int len) {
        return StringUtils.right(value, len);
    }

    /**
     * 지정한 위치 부터 설정된 길이까지 스트링을 리턴 한다. 만약 검색 대상이 넘어 가면 에러 없이 "" 값을 리턴 한다. <br />
     * getStringService().mid(null, *, *) = null<br/>
     * getStringService().mid(*, *, -ve) = ""<br/>
     * getStringService().mid("", 0, *) = ""<br/>
     * getStringService().mid("abc", 0, 2) = "ab"<br/>
     * getStringService().mid("abc", 0, 4) = "abc"<br/>
     * getStringService().mid("abc", 2, 4) = "c"<br/>
     * getStringService().mid("abc", 4, 2) = ""<br/>
     * getStringService().mid("abc", -2, 2) = "ab"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param pos
     *            검색 시작 위치
     * @param len
     *            검색 길이
     * @return String String 검색된 스트링
     */
    public static String mid(String value, int pos, int len) {
        return StringUtils.mid(value, pos, len);
    }

    /**
     * 스트링을 지정된 문자로 split 한다. <br />
     * getStringService().split(null, *) = null getStringService().split("", *)<br/>
     * getStringService().split("abc def", null) = ["abc", "def"]<br/>
     * getStringService().split("abc def", " ") = ["abc", "def"]<br/>
     * getStringService().split("abc def", " ") = ["abc", "def"]<br/>
     * getStringService().split("ab:cd:ef", ":") = ["ab", "cd", "ef"]<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param searchString
     *            구분 값
     * @return String[] 분리된 스트링 배열
     */
    public static String[] split(String value, String searchString) {
        return StringUtils.split(value, searchString);
    }

    /**
     * camel 표기법으로 split 한다. <br />
     * getStringService().splitByCharacterTypeCamelCase(null) = null<br/>
     * getStringService().splitByCharacterTypeCamelCase("") = []<br/>
     * getStringService().splitByCharacterTypeCamelCase("ab de fg") = ["ab", " ", "de", " ", "fg"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("ab de fg") = ["ab", " ", "de", " ", "fg"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("ab:cd:ef") = ["ab", ":", "cd", ":", "ef"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("number5") = ["number", "5"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("fooBar") = ["foo", "Bar"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("foo200Bar") = ["foo", "200", "Bar"]<br/>
     * getStringService().splitByCharacterTypeCamelCase("ASFRules") = ["ASF", "Rules"]<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @return String[] 분리된 스트링 배열
     */
    public static String[] splitByCharacterTypeCamelCase(String value) {
        return StringUtils.splitByCharacterTypeCamelCase(value);
    }

    /**
     * String 배열을 하나의 스트링으로 합친다. <br />
     * getStringService().join(null) = null<br/>
     * getStringService().join([]) = ""<br/>
     * getStringService().join([null]) = ""<br/>
     * getStringService().join(["a", "b", "c"]) = "abc"<br/>
     * getStringService().join([null, "", "a"]) = "a"<br/>
     *
     * @param <T>
     *            the generic type
     * @param elements
     *            스트링 배열
     * @return String 합쳐진 스트링
     */
    public static <T> String join(T... elements) {
        return StringUtils.join(elements);
    }

    /**
     * null 또는 모든 공백 문자를 삭제 한다. <br />
     * getStringService().deleteWhitespace(null) = null<br/>
     * getStringService().deleteWhitespace("") = ""<br/>
     * getStringService().deleteWhitespace("abc") = "abc"<br/>
     * getStringService().deleteWhitespace(" ab c ") = "abc"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @return String 공백이 제거된 스트링
     */
    public static String deleteWhitespace(String value) {
        return StringUtils.deleteWhitespace(value);
    }

    /**
     * 스트링에서 해당 문자열에 포함된 것들은 삭제 한다. <br />
     * getStringService().remove(null, *) = null<br/>
     * getStringService().remove("", *) = ""<br/>
     * getStringService().remove(*, null) = *<br/>
     * getStringService().remove(*, "") = *<br/>
     * getStringService().remove("queued", "ue") = "qd"<br/>
     * getStringService().remove("queued", "zz") = "queued"<br/>
     *
     * @param value
     *            검증 대상 소스 스트링
     * @param remove
     *            제거할 문자열
     * @return String 제거된 전체 스트링
     */
    public static String remove(String value, String remove) {
        return StringUtils.remove(value, remove);
    }

    /**
     * 스트링에서 콤마','를 제거 한다. <br />
     * getStringService().removeComma("ab,cd" = abcd<br/>
     *
     * @param value
     *            [설명]
     * @return String [설명]
     */
    public static String removeComma(String value) {
        return StringUtils.remove(value, ",");
    }

    /**
     * 스트링에서 콤마'-'를 제거 한다. <br />
     * getStringService().removeComma("ab,cd" = abcd<br/>
     *
     * @param value
     *            [설명]
     * @return String [설명]
     */
    public static String removeHyphen(String value) {
        return StringUtils.remove(value, "-");
    }

    /**
     * 특정 문자열을 치환 한다. <br />
     * getStringService().replace(null, *, *) = null<br/>
     * getStringService().replace("", *, *) = ""<br/>
     * getStringService().replace("any", null, *) = "any"<br/>
     * getStringService().replace("any", *, null) = "any"<br/>
     * getStringService().replace("any", "", *) = "any"<br/>
     * getStringService().replace("aba", "a", null) = "aba"<br/>
     * getStringService().replace("aba", "a", "") = "b"<br/>
     * getStringService().replace("aba", "a", "z") = "zbz"<br/>
     *
     * @param text
     *            소스 스트링
     * @param searchString
     *            치환 대상 문자열
     * @param replacement
     *            치환할 문자열
     * @return String 치환된 문자열
     */
    public static String replace(String text, String searchString, String replacement) {
        return StringUtils.replace(text, searchString, replacement);
    }

    /**
     * 갯수만큼 문자열을 복사 한다. <br />
     * getStringService().repeat(null, 2) = null<br/>
     * getStringService().repeat("", 0) = ""<br/>
     * getStringService().repeat("", 2) = ""<br/>
     * getStringService().repeat("a", 3) = "aaa"<br/>
     * getStringService().repeat("ab", 2) = "abab"<br/>
     * getStringService().repeat("a", -2) = ""<br/>
     *
     * @param value
     *            복사할 문자열
     * @param repeat
     *            복사할 수
     * @return String 치환된 문자열
     */
    public static String repeat(String value, int repeat) {
        return StringUtils.repeat(value, repeat);
    }

    /**
     * 지정된 숫자 만큼 오른쪽 패잉으로 치환 한다. <br />
     * StringUtils.rightPad(null, *, *) = null<br/>
     * StringUtils.rightPad("", 3, 'z') = "zzz"<br/>
     * StringUtils.rightPad("bat", 3, 'z') = "bat"<br/>
     * StringUtils.rightPad("bat", 5, 'z') = "batzz"<br/>
     * StringUtils.rightPad("bat", 1, 'z') = "bat"<br/>
     * StringUtils.rightPad("bat", -1, 'z') = "bat"<br/>
     *
     * @param value
     *            대상 문자열
     * @param size
     *            패딩 수
     * @param padChar
     *            패딩 문자열
     * @return String 변환된 문자열
     */
    public static String rightPad(String value, int size, char padChar) {
        return StringUtils.rightPad(value, size, padChar);
    }

    /**
     * 지정된 숫자 만큼 오른쪽 패잉으로 치환 한다. <br />
     * getStringService().rightPad(null, *, *) = null<br/>
     * getStringService().rightPad("", 3, 'z') = "zzz"<br/>
     * getStringService().rightPad("bat", 3, 'z') = "bat"<br/>
     * getStringService().rightPad("bat", 5, 'z') = "batzz"<br/>
     * getStringService().rightPad("bat", 1, 'z') = "bat"<br/>
     * getStringService().rightPad("bat", -1, 'z') = "bat"<br/>
     *
     * @param value
     *            대상 문자열
     * @param size
     *            패딩 수
     * @param padStr
     *            패딩 스트링
     * @return String 변환된 문자열
     */
    public static String rightPad(String value, int size, String padStr) {
        return StringUtils.rightPad(value, size, padStr);
    }

    /**
     * 지정된 숫자 만큼 왼쪽 패잉으로 치환 한다. <br />
     * getStringService().leftPad(null, *, *) = null<br/>
     * getStringService().leftPad("", 3, 'z') = "zzz"<br/>
     * getStringService().leftPad("bat", 3, 'z') = "bat"<br/>
     * getStringService().leftPad("bat", 5, 'z') = "zzbat"<br/>
     * getStringService().leftPad("bat", 1, 'z') = "bat"<br/>
     * getStringService().leftPad("bat", -1, 'z') = "bat"<br/>
     *
     * @param value
     *            대상 문자열
     * @param size
     *            패딩 수
     * @param padChar
     *            패딩 스트링
     * @return String 변환된 문자열
     */
    public static String leftPad(String value, int size, char padChar) {
        return StringUtils.leftPad(value, size, padChar);
    }

    /**
     * 지정된 숫자 만큼 왼쪽 패잉으로 치환 한다. <br />
     * getStringService()()ils.leftPad(null, *, *) = null<br/>
     * getStringService().leftPad("", 3, "z") = "zzz"<br/>
     * getStringService().leftPad("bat", 3, "yz") = "bat"<br/>
     * getStringService().leftPad("bat", 5, "yz") = "yzbat"<br/>
     * getStringService().leftPad("bat", 8, "yz") = "yzyzybat"<br/>
     * getStringService().leftPad("bat", 1, "yz") = "bat"<br/>
     * getStringService().leftPad("bat", -1, "yz") = "bat"<br/>
     * getStringService().leftPad("bat", 5, null) = " bat"<br/>
     * getStringService().leftPad("bat", 5, "") = " bat"<br/>
     *
     * @param value
     *            대상 문자열
     * @param size
     *            패딩 수
     * @param padStr
     *            패딩 스트링
     * @return String 변환된 문자열
     */
    public static String leftPad(String value, int size, String padStr) {
        return StringUtils.leftPad(value, size, padStr);
    }

    /**
     * 숫자+영문 조합 유무 체크. <br />
     * getStringService().isAlphanumeric(null) = false<br/>
     * getStringService().isAlphanumeric("") = false<br/>
     * getStringService().isAlphanumeric(" ") = false<br/>
     * getStringService().isAlphanumeric("abc") = true<br/>
     * getStringService().isAlphanumeric("ab c") = false<br/>
     * getStringService().isAlphanumeric("ab2c") = true<br/>
     * getStringService().isAlphanumeric("ab-c") = false<br/>
     *
     *
     * @param value
     *            검증 문자열
     * @return true:숫자+영문 조합일 경우, false:아닐 경우
     */
    public static boolean isAlphanumeric(String value) {
        return StringUtils.isAlphanumeric(value);
    }

    /**
     * 숫자일 경우만 true를 리턴 한다. <br />
     * getStringService().isNumeric(null) = false<br/>
     * getStringService().isNumeric("") = false<br/>
     * getStringService().isNumeric(" ") = false<br/>
     * getStringService().isNumeric("123") = true<br/>
     * getStringService().isNumeric("12 3") = false<br/>
     * getStringService().isNumeric("ab2c") = false<br/>
     * getStringService().isNumeric("12-3") = false<br/>
     * getStringService().isNumeric("12.3") = false<br/>
     *
     * @param value
     *            검증 문자열
     * @return true:숫자일 경우, false:숫자가 아닐경우
     */
    public static boolean isNumeric(String value) {
        return StringUtils.isNumeric(value);
    }

    /**
     * 숫자를 캐릭터 형태로 변환 한다.
     *
     * @param value
     *            아스키코드 숫자
     * @return String 변환된 데이터
     */
    public static String convertIntChar(int value) {
        String result = String.valueOf(value);
        if (value < 10) {
            result = "0" + value;
        }
        return result;
    }

    /**
     * List를 CSV 형태로 만들어서 string을 리턴 한다.
     *
     * @param values
     *            스트링 형 리스트
     * @return String CSV 포맷 스트링
     */
    public static String convertListtoCSV(List<String> values) {
        StringBuilder sb = new StringBuilder();
        // 객체가 존재 하지 않을 경우
        if (values == null) {
            return sb.toString();
        }

        int listSize = values.size();
        if (listSize == 0) {
            return sb.toString();
        }

        int loopCount = 1;
        for (String value : values) {
            sb.append(value);
            if (loopCount < listSize) {
                sb.append(",");
            }
            loopCount++;
        }
        return sb.toString();
    }

    /**
     * Map를 CSV 형태로 만들어서 string을 리턴 한다.
     *
     * @param map
     *            스트링 형의 맵
     * @return String CSV로 변환된 데이터
     */
    public static String convertMaptoCSV(Map<String, Object> map) {
        StringBuilder value = new StringBuilder();
        // 객체가 존재 하지 않을 경우
        if (map == null) {
            return value.toString();
        }

        int mapSize = map.size();
        Iterator<Object> iterator = map.values().iterator();
        int loopCount = 1;
        // item을 파싱해서 Object[] 형태로 리턴 한다.
        while (iterator.hasNext()) {
            value.append((String) iterator.next());
            if (loopCount < mapSize) {
                value.append(",");
            }
            loopCount++;
        }

        return value.toString();
    }

    /**
     * HTML을 이스케이핑 한다.
     *
     * @param text
     *            HTML 텍스트 문자열
     * @return String 이스케이핑된 문자열
     */
    public static String parseHtmlString(final String text) {
        String strText = text;
        if (strText == null) {
            strText = "";
        }
        strText = replace(strText, "\n", "&#35;");
        strText = replace(strText, "<br />", "\n");
        strText = replace(strText, "<br>", "\n");
        strText = replace(strText, "<", "&lt;");
        strText = replace(strText, ">", "&gt;");
        strText = replace(strText, "&nbsp;", " ");
        strText = replace(strText, (char) 37 + "", "&#37;");
        strText = replace(strText, (char) 34 + "", "&quot;");
        strText = replace(strText, (char) 39 + "", "&#39;");

        return strText;
    }

    /**
     * 이스케이핑된 문자열을 HTML로 변환 한다.
     *
     * @param text
     *            이스케이핑된 문자열
     * @return String html로 변환된 문자열
     */
    public static String reverseHtmlString(final String text) {
        String strText = text;
        if (strText == null) {
            strText = "";
        }
        strText = replace(strText, "\n", "<br />");
        strText = replace(strText, "&lt;", "<");
        strText = replace(strText, "&gt;", ">");
        strText = replace(strText, "&#37;;", (char) 37 + "");
        strText = replace(strText, "&quot;", (char) 34 + "");
        strText = replace(strText, "&#39;", (char) 39 + "");
        strText = replace(strText, "&#35;", "\n");

        return strText;
    }

    /**
     * 이 메일 형식 유무 체크.
     *
     * @param str
     *            이메일 문자열
     * @return true:이메일 형식일 경우, false:이메일 형식이 아닐경우
     */
    public static boolean isEmail(final String str) {
        boolean isEmail = false;
        if (str.indexOf("@") > -1 && str.indexOf(".") > -1) {
            isEmail = true;
        }
        return isEmail;
    }

    /**
     * 개행 문자들을 br태그로 치환 한다.
     *
     * @param comment
     *            개행문자가 포함된 문자열
     * @return String br 태그로 치환된 문자열
     */
    public static String convertHtmlBr(final String comment) {
        if (comment == null || comment.trim().length() == 0) {
            return "";
        }

        int length = comment.length();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String tmp = comment.substring(i, i + 1);
            if ("\r".compareTo(tmp) == 0) {
                String tmp2 = comment.substring(++i, i + 1);
                if ("\n".compareTo(tmp2) == 0) {
                    buffer.append("<br/>\r");
                } else {
                    buffer.append("\r");
                }
            } else if ("\n".compareTo(tmp) == 0) {
                buffer.append("<br/>");
            }
            buffer.append(tmp);
        }
        return buffer.toString();
    }

    /**
     * 시작 문자열 과 마지막 문자열을 지정하면 그 안에 있는 문자열을 리턴 한다. <br />
     * String value = "[hello]"; logger.info(getStringService.substringBetween(value, "[", "]")) hello
     *
     * @param value
     *            [설명]
     * @return String [설명]
     */
    public static String substringBetween(final String value, String open, String close) {
        return StringUtils.substringBetween(value, open, close);
    }

    /**
     * <pre>
    * 6,8자리 문자열을 날짜포맷으로 리턴한다.
    * getStringService().stringToDateFormat("20160218",".");
    * getStringService().stringToDateFormat("20160218","년,월,일");
    * getStringService().stringToDateFormat("201602",".");
    * getStringService().stringToDateFormat("201602","년,월");
     * </pre>
     *
     * @param value
     * @param delimeter
     * @return
     */
    public static String stringToDateFormat(final String value, String delimiter) {
        String ret = null;
        String delimiter1 = "";
        String delimiter2 = "";
        String delimiter3 = "";

        if (!StringUtils.isEmpty(value)) {
            if (delimiter.length() > 1 && delimiter.indexOf(",") > -1) {
                if (value.length() == 8) {
                    delimiter1 = delimiter.split(",")[0];
                    delimiter2 = delimiter.split(",")[1];
                    delimiter3 = delimiter.split(",")[2];
                } else if (value.length() == 6) {
                    delimiter1 = delimiter.split(",")[0];
                    delimiter2 = delimiter.split(",")[1];
                }
            } else {
                delimiter1 = delimiter;
                delimiter2 = delimiter;
                delimiter3 = "";

                if (value.length() == 6) {
                    delimiter2 = "";
                }
            }

            if (value.length() == 8) {
                ret = value.substring(0, 4) + delimiter1 + value.substring(4, 6) + delimiter2 + value.substring(6) + delimiter3;
            } else if (value.length() == 6) {
                ret = value.substring(0, 4) + delimiter1 + value.substring(4, 6) + delimiter2;
            }
        } else {
            ret = value;
        }
        return ret;
    }

    /**
     * string 문자를 int 형으로 반환한다. 숫자형이 아니면 return 0
     *
     * @param value
     * @return
     */
    public static int parseInt(String value) {
        int result = 0;
        double parseValue;
        if (value != null && NumberUtils.isNumber(value)) {
            try {
                parseValue = Double.parseDouble(value);
                result = (int) parseValue;
            } catch (NumberFormatException e) {
                result = 0;
            }
        }
        return result;
    }

    /**
     * Hex 2 str.
     *
     * @param data
     *            the data
     * @param offset
     *            the offset
     * @param len
     *            the len
     * @return the string
     */
    private static String hex2Str(byte[] data, int offset, int len) {
        if (data == null)
            return "null";

        StringBuilder out = new StringBuilder(256);
        // hexbytes
        for (int j = offset; j < len; j++) {
            int b = data[j] & 0xff;
            out.append(hexify(b));
        }
        return out.toString();
    }

    /**
     * Hexify string.
     *
     * @param val
     *            the val
     * @return String the string
     */
    private static String hexify(int val) {
        return hexChars[((val & 0xff) & 0xf0) >>> 4] + hexChars[val & 0x0f];
    }

    /**
     * string 문자를 long 형으로 반환한다. 숫자형이 아니면 return 0
     *
     * @param value
     * @return
     */
    public static long parseLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    /**
     * 특수문자 제거 하기
     *
     * @param str
     * @return String
     */
    public static String replaceSpecialChar(String str) {
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        if (str != null && !"".equals(str)) {
            str = str.replaceAll(match, "").replaceAll(" ", "");
        } else {
            str = "";
        }
        return str;
    }

}
