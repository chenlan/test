package junit;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("A")
@Epic("Allure examples")
@Feature("Junit 4 support")
public class JunitDamoTest {

//    @Rule
//    public ErrorCollector errorCollector = new ErrorCollector();


//    @Test
//    @Flaky
//    public void test1() {
//        String m = "";
//        System.out.println("test11");
//       // errorCollector.checkThat(1, equalTo(1));
//        assertThat(5.0, equalTo(5.0));
//       User user = new User();
//        user.name = "张三";
//        user.password = "dddddd";
//        login(user);
//    }

    //@Step("Type {user.name} / {user.password}.")
    public void login(User user) {
        Allure.step("登录用户：" + user.name);
        System.out.println("step1");
        assertThat(user.name, equalTo("张三"));
    }

    @Tag("D")
    @DisplayName("参数接口")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        System.out.println("testWithExplicitLocalMethodSource");
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }


//    @Test
//    @DisplayName("测试用例test3-------")
//   // @Description("用例描述")
//    @Link("https://www.baidu1.com")
//    @TmsLink("https://www.baidu2.commm")
//    @Issue("http://www.baidu3.com")
//    @Tag("严重")
//    @Severity(SeverityLevel.TRIVIAL)
//    @ParameterizedTest
//    @MethodSource("stringIntAndListProvider")
//    public void test3(String name) {
//        //Allure.description(name);
//        Allure.step("登录用户接口:"+name);
//        Allure.issue("bug", "http://www.baidu.com");
//        System.out.println("test3");
//        assertThat(5.0, anyOf(closeTo(4.9, 0.2),
//                equalTo(60)));
//    }

   //@io.qameta.allure.junit4.DisplayName(str)
    @Tag("B")
    @DisplayName("接口")
    @ParameterizedTest(name = "{index} {displayName} {0}")
    @MethodSource
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        System.out.println("testWithMultiArgMethodSourceBBBBB");
        Allure.description("c:"+str);
        assertEquals(5, str.length());
        assertTrue(num >= 1 && num <= 2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> testWithMultiArgMethodSource() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    @Tag("B")
    @Severity(SeverityLevel.MINOR)
    @Flaky
    @Test
    public void test4() {
        System.out.println("test4");
        assertEquals(4,5);
    }


    @Test
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    public void test2() {
        System.out.println("test2");
        assertThat(5.0, anyOf(closeTo(4.9, 0.2),
                equalTo(60)));
    }

    @Test
    public void test3(){
        assertEquals(1,1);
    }


}
