package com.theim.demo.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Utilities for working with jackson json.
 *
 * @author Wachirakorn Pimpong
 */
public final class JacksonUtils {
    private static ObjectMapper mapper = createObjectMapper();

    private JacksonUtils() {
    }

    /**
     * Parses from stream.
     *
     * @param <T> Type of target object
     * @param src input stream
     * @param clz class of target object
     * @return parsed object
     * @throws IOException error
     */
    public static <T> T parse(InputStream src, Class<T> clz) throws IOException {
        return mapper.readValue(src, clz);
    }

    /**
     * Parses from string.
     *
     * @param <T> Type of target object
     * @param src string
     * @param clz class of target object
     * @return parsed object
     * @throws IOException error
     */
    public static <T> T parse(String src, Class<T> clz) throws IOException {
        return mapper.readValue(src, clz);
    }

    /**
     * Parse list.
     *
     * @param src the src
     * @param clz the clz
     * @return the list
     * @throws IOException the iO exception
     */
    public static <T> List<T> parseArray(String src, Class<T> clz) throws IOException {
        return mapper.readValue(src, mapper.getTypeFactory().constructCollectionType(
                List.class, clz));
    }

    /**
     * Parse string.
     *
     * @param object the object
     * @return the string
     * @throws IOException the iO exception
     */
    public static String parse(Object object) throws IOException {
        return mapper.writeValueAsString(object);
    }

    private static ObjectMapper createObjectMapper() {
        ObjectMapper m = new ObjectMapper();
        m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        m.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        //DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        m.setDateFormat(df);

        return m;
    }
}

