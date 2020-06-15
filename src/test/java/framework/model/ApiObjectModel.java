package framework.model;

import io.restassured.response.Response;

import java.util.HashMap;

public class ApiObjectModel {
    public HashMap<String,ApiObjectMethod> methods;

    public Response run(String method, HashMap<String, Object> params) {
        return methods.get(method).run(params);
    }
}
