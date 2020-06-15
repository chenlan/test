package web.testcase;

// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumIDE {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testa() {
        driver.get("https://work.weixin.qq.com/");
        driver.manage().window().setSize(new Dimension(1230, 777));
        driver.findElement(By.linkText("企业登录")).click();
        driver.findElement(By.cssSelector("#menu_contacts > .frame_nav_item_title")).click();
        driver.findElement(By.cssSelector(".js_checkbox_container > .ww_checkbox")).click();
        driver.findElement(By.linkText("邀请")).click();
        driver.findElement(By.linkText("确认")).click();
    }
}
