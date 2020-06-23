package testcase;

import page.App;
import page.StockPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockTest {
    private static StockPage stockPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        stockPage = App.getInstance().toStockPage();
    }

    @Test
    @Order(1)
    public void addDefaultSelecterStocks() {
        if (stockPage.getStockList().size() > 0) {
            stockPage.deleteAll();
        }
        assertThat(stockPage.addSelect().getStockList().size(), Matchers.lessThanOrEqualTo(6));
    }

    @Order(2)
    @ParameterizedTest
    //@ValueSource(String ={"",""})
    @MethodSource("data")
    public void testJunit5(String name, String value) {
        System.out.println(name + "" + value);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments("pdd", "dd"),
                Arguments.arguments("jd", "j")
        );
    }

}
