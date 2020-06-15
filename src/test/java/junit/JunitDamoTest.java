package junit;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import mock.User;
import org.junit.*;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

//@Epic("Allure examples")
//@Feature("Junit 4 support")
public class JunitDamoTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @BeforeClass
    public static void beforClass() {
        System.out.println("beforClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void BeforeTest() {
        System.out.println("before");
    }

    @After
    public void AfterTest() {
        System.out.println("after");
    }

    @Test
    @Flaky
    public void test1() {
        String m = "";
        System.out.println("test11");
        errorCollector.checkThat(1, equalTo(1));
        assertThat(5.0, equalTo(5.0));
        User user = new User();
        user.name = "张三";
        user.password = "dddddd";
        login(user);
    }

    //@Step("Type {user.name} / {user.password}.")
    public void login(User user) {
        Allure.step("登录用户：" + user.name);
        System.out.println("step1");
        assertThat(user.name, equalTo("张三1"));
    }

    @Test
    @DisplayName("测试用例test3")
    @Description("用例描述")
    @Link("https://www.baidu1.com")
    @TmsLink("https://www.baidu2.commm")
    @Issue("http://www.baidu3.com")
    @Tag("严重")
    @Severity(SeverityLevel.TRIVIAL)
    public void test3() {
        Allure.issue("bug", "http://www.baidu.com");
        System.out.println("test3");
        assertThat(5.0, anyOf(closeTo(4.9, 0.2),
                equalTo(60)));
    }

    @Severity(SeverityLevel.MINOR)
    @Flaky
    @Test
    public void test4() {
        System.out.println("test4");
    }


    @Test
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    public void test2() {
        System.out.println("test2");
        assertThat(5.0, anyOf(closeTo(4.9, 0.2),
                equalTo(60)));
    }
}
