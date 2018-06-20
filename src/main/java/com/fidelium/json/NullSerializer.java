package com.fidelium.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * <pre>
 * 시스템 : ncms-app-server
 * TYPE  : Serializer  
 * Desc. : Json 마샬링 할경우 Object가 null이면 ""으로 처리 함.
 * </pre>
 * 
 * @author 1700082@partner.skcc.com
 * @since 2017. 4. 19.
 * 
 * @see
 */
public class NullSerializer extends JsonSerializer<Object> {

    /*
     * (non-Javadoc)
     * 
     * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
     */
    @Override
    public void serialize(Object value, JsonGenerator jsonGen, SerializerProvider provider) throws IOException {
        jsonGen.writeString("");
    }

}
