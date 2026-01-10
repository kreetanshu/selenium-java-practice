package com.example.automation.utils.commonUtils;

import com.example.automation.pojo.ResponseReqRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    public static ResponseReqRes jsonToPojo(String jsonReponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonReponse, ResponseReqRes.class);
    }

    public static String pojoToJson(Object pojo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
    }
}
