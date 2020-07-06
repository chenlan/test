package service;

import common.UtilTool;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ApiObjectMethod {
    public HashMap<String,Object> querys;
    public HashMap<String,Object> headers;
    public HashMap<String,Object> postBody;
    public String name;
    public String description;
    public String postBodyRaw;
    public String method = "get";
    public String url = "";
    public String filter;
    private HashMap<String, Object> params;


    public Response run(HashMap<String, Object> params) {
        this.params = params;
        return run();
    }

    private Response run(){
        RequestSpecification requestSpecification = given();

        if(filter!=null){
            try {
                Object filterObj =  Class.forName(filter).getDeclaredConstructor().newInstance();
                requestSpecification.filter((Filter) filterObj);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        requestSpecification.queryParam("access_token",
                SecretToken.getInstance().getWorkToken());
        if(querys!=null){
            requestSpecification.queryParams(replaceMap(querys));
        }
        if(headers!=null){
            requestSpecification.headers(replaceMap(headers));
        }
        if(postBody!=null){
            requestSpecification.body(replaceMap(postBody));
        }
        if(postBodyRaw!=null){
            requestSpecification.body(postBodyRaw);
        }

        return requestSpecification
                .when().log().all().request(method,url)
                .then().log().all().extract().response();
    }

    private HashMap<String,Object> replaceMap(HashMap<String,Object> map){
        HashMap<String,Object> replaceNewMap = new HashMap<>();
        for (Map.Entry<String,Object> item : map.entrySet()){
            replaceNewMap.put(item.getKey(),replaceString(item.getValue().toString()));
        }
        return replaceNewMap;
    }

    private String replaceString(String valueRaw){
        List<String> params = UtilTool.getParam(valueRaw);
        for (String param : params){
             String matcher = "${"+param+"}";
             valueRaw = valueRaw.replace(matcher,this.params.get(param).toString());
        }
        return valueRaw;
    }

}
