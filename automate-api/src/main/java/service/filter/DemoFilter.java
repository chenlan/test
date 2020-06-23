package service.filter;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class DemoFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response responseOrigin=ctx.next(requestSpec, responseSpec);

        String bodyNew = responseOrigin.body().asString();
        System.out.println("qiang:"+bodyNew);
        String dddd  = bodyNew.replace("\"陈蓝\"", "\"YQQQQQ\"");
        System.out.println("hou:"+dddd);
        ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOrigin);
        responseBuilder.setBody(bodyNew);
        return responseBuilder.build();



//       Response r= new ResponseBuilder().clone(responseOrigin).setStatusCode(404).build();
//        System.out.println("========:"+r.getStatusLine());
//        return r;
//        requestSpec.queryParam("access_token",
//                SecretToken.getInstance().getWorkToken());
//        Response resReal = ctx.next(requestSpec, responseSpec);
//        System.out.println("---------:"+resReal.getStatusLine());
//        return resReal;
    }
}