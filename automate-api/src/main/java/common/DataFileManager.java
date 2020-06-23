package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class DataFileManager {

    public static <T> T readValue(String resourcePath, Class<T> t) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        T data = null;
        try {
            data = objectMapper.readValue(DataFileManager.class.getResourceAsStream(resourcePath), t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
