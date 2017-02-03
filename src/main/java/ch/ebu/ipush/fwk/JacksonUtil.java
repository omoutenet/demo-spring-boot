package ch.ebu.ipush.fwk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Utility class to convert Json to Object and reverse
 */
public class JacksonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtil.class);


    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JacksonUtil() {
    }

    /**
     * Transform a string to the clazz
     *
     * @param string json content
     * @param clazz  class
     * @param <T>    type
     * @return a new T
     */
    public static <T> T fromString(String string, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(string, clazz);
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new IllegalArgumentException("The given string value: " + string + " cannot be transformed to Json object");
        }
    }

    /**
     * Transform an object to json
     *
     * @param value Plain object
     * @return json string
     */
    public static String toString(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            LOGGER.error("", e);
            throw new IllegalArgumentException("The given Json object value: " + value + " cannot be transformed to a String");
        }
    }

    /**
     * Convert a json string to a Json Node
     *
     * @param value json string
     * @return Json node
     */
    public static JsonNode toJsonNode(String value) {
        try {
            return OBJECT_MAPPER.readTree(value);
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new IllegalArgumentException(e);
        }
    }

    public static Object toObject(String value) {
        try {
            return OBJECT_MAPPER.readValue(value, Object.class);
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T toObjectByClass(String value, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(value, clazz);
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new IllegalArgumentException(e);
        }
    }


    public static <T> T clone(T value) {
        return fromString(toString(value), (Class<T>) value.getClass());
    }
}