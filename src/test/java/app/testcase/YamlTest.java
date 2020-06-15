package app.testcase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.model.PageObjectModel;
import framework.util.DataFileManager;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class YamlTest {

    @Test
    public void yamlTest() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        String yamlPath ="/"+SearchTest.class.getCanonicalName().replace('.','/');
//        URL url = this.getClass().getResource("/app/page/SearchPage");
//        PageObjectModel model= objectMapper.readValue(SearchTest.class.getResourceAsStream("/app/page/SearchPage"), PageObjectModel.class);
//
        PageObjectModel model = DataFileManager.readValue("/app/page/SearchPage", PageObjectModel.class);
        System.out.println(model.methods);
    }
}
