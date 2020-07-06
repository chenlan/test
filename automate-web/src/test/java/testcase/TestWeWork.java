package testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TestWeWork {
    private WebDriver driver;
    private static String url = "https://work.weixin.qq.com/";

    @Test
    public void testa() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1230, 777));

        driver.manage().addCookie(new Cookie("wwrtx.refid", "34144002922744648"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "RjSQhUKPiTnPTVz0cAmD_8aHftfItP1QR789iXXawS3b477ladJf-pl4e5h9KtGD"));

//        driver.manage().getCookies().forEach(cookie -> {
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
//        });
        driver.findElement(By.linkText("企业登录")).click();

        driver.findElement(By.cssSelector("#menu_contacts > .frame_nav_item_title")).click();
        driver.findElement(By.cssSelector(".js_checkbox_container > .ww_checkbox")).click();
        driver.findElement(By.linkText("邀请")).click();
        driver.findElement(By.linkText("确认")).click();
        driver.quit();
    }
}
