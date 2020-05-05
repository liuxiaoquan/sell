package com.itcast.sell.utils.serializer;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * @author LXQ
 * @create 2019-01-29 10:46
 */
public class Date2LongSerializer extends JsonSerializer<Date>{
    @Override
    public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(value.getTime() / 1000);
    }
}
