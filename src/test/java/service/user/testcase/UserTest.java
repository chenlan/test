package service.user.testcase;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.user.api.User;

import static org.hamcrest.Matchers.equalTo;

public class UserTest {
    private static User user;
    @BeforeAll
    public static void UserApi(){
        user = new User();
    }
    @Test
    public void get(){
        user.get("ChenLan").then().body("name", Matchers.containsString("蓝"));
    }


}
