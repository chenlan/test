package service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SecretToken {
    private static SecretToken secretToken;
    private String workToken;

    public static SecretToken getInstance(){
        if(secretToken == null){
            secretToken = new SecretToken();
        }
        return  secretToken;
    }


    public String getWorkToken(){
        if(workToken==null){
            workToken = given()
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
            System.out.println(workToken);
        }
        return workToken;
    }
}
