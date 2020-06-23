package service;


import common.DataFileManager;
import io.restassured.response.Response;
import service.ApiObjectModel;

import java.util.HashMap;

public class BaseApi {
    private ApiObjectModel model;
    public BaseApi(){
    }
    /**
     * 初始化数据
     */
    public void initializeData() {
        try {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            String url = "/" + Class.forName(className).getCanonicalName().replace('.', '/');
            model = DataFileManager.readValue(url, ApiObjectModel.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Response run(HashMap<String,Object> params){
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        return model.run(method,params);
    }
}
