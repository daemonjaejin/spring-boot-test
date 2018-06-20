package com.fidelium.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fidelium.json.NullSerializer;

import java.io.IOException;

public class JsonUtil {

    /**
     * Default Constructor
     */
    private JsonUtil() {
    }

    /**
     * 오브젝트를 JSON 형태로 마샬링 한다.
     * 
     * @param object
     *            the object
     * @return the string
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public static String marshallingJson(final Object object) throws JsonProcessingException {
        return parseJson(false, object);
    }

    /**
     * 오브젝트를 JSON 데이터로 사람이 보기 편한 형태로 마샬링 한다.
     * 
     * @param object
     *            the object
     * @return the string
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public static String marshallingJsonWithPretty(final Object object) throws JsonProcessingException {
        return parseJson(true, object);
    }

    /**
     * 실제로 오브젝트를 Json 텍스트로 마샬링 한다.
     *
     * @param pretty
     *            the pretty
     * @param object
     *            the object
     * @return the string
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    private static String parseJson(boolean pretty, Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.ALWAYS);
        DefaultSerializerProvider provider = new DefaultSerializerProvider.Impl();
        provider.setNullValueSerializer(new NullSerializer());
        objectMapper.setSerializerProvider(provider);

        // 보기 편하게 출력
        if (pretty) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
        return objectMapper.writeValueAsString(object);
    }

    /**
     * JSON 형태의 스트링을 특정 오브젝트로 언마샬링 한다.
     * 
     * @param jsonText
     *            the json text
     * @param valueType
     *            the value type
     * @return the t
     * @throws java.io.IOException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws com.fasterxml.jackson.core.JsonParseException
     */
    public static <T> T unmarshallingJson(final String jsonText, final Class<T> valueType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = jsonText.replaceAll("null", "\"\"");
        T t = (T) objectMapper.readValue(data, valueType);

        return t;
    }

    public static String getPretty(String jsonString) {
        final String INDENT = "    ";
        StringBuilder prettyJsonSb = new StringBuilder();

        int indentDepth = 0;
        for (int i = 0; i < jsonString.length(); i++) {
            String targetString = jsonString.substring(i, i + 1);
            if ("{".equals(targetString) || "[".equals(targetString)) {
                prettyJsonSb.append(targetString).append("\n");
                indentDepth++;
                for (int j = 0; j < indentDepth; j++) {
                    prettyJsonSb.append(INDENT);
                }
            } else if ("}".equals(targetString) || "]".equals(targetString)) {
                prettyJsonSb.append("\n");
                indentDepth--;
                for (int j = 0; j < indentDepth; j++) {
                    prettyJsonSb.append(INDENT);
                }
                prettyJsonSb.append(targetString);
            } else if (",".equals(targetString)) {
                prettyJsonSb.append(targetString);
                prettyJsonSb.append("\n");
                for (int j = 0; j < indentDepth; j++) {
                    prettyJsonSb.append(INDENT);
                }
            } else {
                prettyJsonSb.append(targetString);
            }
        }
        return prettyJsonSb.toString();
    }

    public static String getDefaultPretty(String jsonString) throws IOException {
        ObjectMapper jacksonMapper = new ObjectMapper();
        Object json = jacksonMapper.readValue(jsonString, Object.class);
        return jacksonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }

}
