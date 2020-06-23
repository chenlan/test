package testcase;


import page.App;
import page.SearchPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class SearchTest {

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforAll() throws MalformedURLException {
    }

    @Parameterized.Parameters
    public static List<String> data() throws IOException {
//        List<String> list = new ArrayList<>();
//        list.add("xiaomi");
//        list.add("alibaba");
//        list.add("jd");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        String yamlPath = "/" + SearchTest.class.getCanonicalName().replace('.', '/');
        List<String> list = objectMapper.readValue(SearchTest.class.getResourceAsStream(yamlPath), ArrayList.class);
        return list;
    }

    @Parameterized.Parameter
    public String stock;

    @Test
    public void search() {
        assertThat(searchPage.search(stock).getCurrentPrice(), Matchers.greaterThanOrEqualTo(1.0F));
    }

    @Before
    public void beforxx() {
        searchPage = App.getInstance().toSearch();
    }

    @After
    public void after() {
        searchPage.cancel();
    }
}
