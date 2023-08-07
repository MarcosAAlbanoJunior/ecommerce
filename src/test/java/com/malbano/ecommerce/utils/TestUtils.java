package com.malbano.ecommerce.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertObjectToJson(Object object) throws Exception {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T convertJsonToObject(String json, Class<T> valueType) throws Exception {
        return objectMapper.readValue(json, valueType);
    }
}