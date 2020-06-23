package service.user;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import service.BaseApi;
import service.SecretToken;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;


public class User extends BaseApi {
    public User(){
        initializeData();
    }

    public Response get(String userid){
        HashMap<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return run(params);
//        given().queryParam("access_token", SecretToken.getInstance().getWorkToken())
//                .queryParam("userid",userid)
//                .when().get("https://qyapi.weixin.qq.com/cgi-bin/user/get")
//                .then().log().all().extract().response();
    }

    public Response update(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);

        return RestAssured.given()
                .queryParam("access_token", SecretToken.getInstance().getWorkToken())
                .body(data)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/update")
                .then().extract().response();
    }


    public Response create(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);

        return RestAssured.given()
                .queryParam("access_token", SecretToken.getInstance().getWorkToken())
                .body(data)
                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();
    }

    public Response clone(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        String bodyData=template("/service/user/user.json", data);
        return RestAssured.given()
                .queryParam("access_token", SecretToken.getInstance().getWorkToken())
                .body(bodyData)
                .when().log().all().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();
    }

    private String template(String templatePath, HashMap<String, Object> data) {
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(templatePath).getPath());
        mustache.execute(writer,data);
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
