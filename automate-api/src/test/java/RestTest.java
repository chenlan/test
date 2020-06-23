import io.restassured.http.ContentType;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestTest {
    public static String token;
    public int parentid=2;

    @BeforeAll
    public static void getToken(){

        token = given()
                .param("corpid","wwe47d7f65ba62991e")
                .param("corpsecret","8YhSjv_yqEXJqslBW30huP3fvCEAILxnefUDx8X73uY")
        .when()
                .log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .body("errcode",equalTo(0))
        .extract()
                .body().path("access_token");
        System.out.println(token);
    }

    @Test
    public void addB(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","广州研发中心");
        map.put("name_en","RDGZ");
        map.put("parentid",parentid);

        given()
             .queryParam("access_token",token).contentType(ContentType.JSON).body(map)
        .when()
             .log().all()
             .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then()
                .log().all()
             .body("errcode",equalTo(0));
    }


}
