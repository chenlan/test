package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {
    private static App app;

    public static App getInstance() {
        if (app == null) {
            app = new App();
            start();
        }
        return app;
    }

    private static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        //desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("udid", System.getenv("UDID"));
        //desiredCapabilities.setCapability("noReset",true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        new WebDriverWait(driver,50).until(x->{
            handleAlert();
            String xml = driver.getPageSource();
            Boolean find = xml.contains("home_search") || xml.contains("image_cancel");
            System.out.println("首页："+find);
            return find;
        });
        System.out.println("======================");
    }

    public void end() {
        driver.close();
    }

    public SearchPage toSearch() {
        MobileElement el1 = (MobileElement) findElement(By.id("home_search"));
        el1.click();
        return new SearchPage();
    }

    public StockPage toStockPage() {
        click(By.xpath("//*[contains('@resource-id','tab_name') and @text='行情']"));
        return new StockPage();
    }
}
