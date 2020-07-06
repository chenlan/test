package service;


import common.DataFileManager;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ApiObjectModel;
import service.user.UserPo;

import java.util.HashMap;

public class BaseApi {
    private static final Logger log = LoggerFactory.getLogger(BaseApi.class);
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
            log.info("初始化开始:"+className);
            model = DataFileManager.readValue(url, ApiObjectModel.class);
            log.info("初始化结束:"+className);
        } catch (ClassNotFoundException e) {
            log.error(e.toString());
            e.printStackTrace();

        }
    }

    public Response run(HashMap<String,Object> params){
        String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        return model.run(method,params);
    }
}
