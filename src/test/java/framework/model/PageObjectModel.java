package framework.model;

import app.page.App;
import app.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class PageObjectModel {
    public HashMap<String, PageObjectElement> elements;
    public HashMap<String, PageObjectMethod> methods;


    public HashMap<String, Object> runSteps(String method, HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        methods.get(method).steps.forEach(step -> {
            //定位元素
            WebElement element = getWebElement(step);
            //元素事件
            elementAction(params, result, step, element);
        });
        return result;
    }

    private void elementAction(HashMap<String, Object> params, HashMap<String, Object> result, HashMap<String, String> step, WebElement element) {
        if (step.containsKey("send")) {
            String sendValue = step.get("send");
            if (params != null) {
                for (String paramKey : params.keySet()) {
                    String matcher = "${" + paramKey + "}";
                    if (sendValue.contains(matcher)) {
                        sendValue = sendValue.replace(matcher, params.get(paramKey).toString());
                        break;
                    }
                }
            }
            element.sendKeys(sendValue);
        } else if (step.containsKey("get")) {
            String attributeValue = element.getAttribute(step.get("get"));
            result.put(step.get("dump"), attributeValue);
        } else {
            element.click();
        }
    }

    private WebElement getWebElement(HashMap<String, String> step) {
        WebElement element = null;
        if (step.containsKey("id")) {
            element = BasePage.findElement(By.id(step.get("id")));
        } else if (step.containsKey("xpath")) {
            element = BasePage.findElement(By.xpath(step.get("xpath")));
        } else if (step.containsKey("aid")) {
            element = BasePage.findElement(MobileBy.AccessibilityId(step.get("aid")));
        } else if (step.containsKey("element")) {
            By by = elements.get(step.get("element")).getBy();
            element = BasePage.findElement(by);
        } else {
            System.out.println("cuowu-----");
        }
        return element;
    }
}
