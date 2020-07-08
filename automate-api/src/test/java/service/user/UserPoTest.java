package service.user;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;


@Epic("通讯录管理")
@Feature("成员管理")
public class UserPoTest {
    private static UserPo userPo;

    @BeforeAll
    public static void UserApi(){
        userPo = new UserPo();
    }

    @Tag("fast")
    @Story("读取成员")
    @DisplayName("读取成员")
    @ParameterizedTest(name = "{index} {0}")
    @MethodSource("service.user.UserTestData#get")
    public void getSuccess(String description,String value,String errmsg,int errcode){
        Allure.description(description);
        userPo.get(value).then()
                .body("errmsg",Matchers.containsString(errmsg))
                .body( "errcode", Matchers.equalTo(errcode));
    }

    @Test
    @Tag("slow")
    @DisplayName("读取成员")
    public void postUser(){
        assertThat("1",Matchers.equalTo("1"));
    }

}
