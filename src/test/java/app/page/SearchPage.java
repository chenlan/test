package app.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.HashMap;

public class SearchPage extends BasePage {

    public SearchPage() {
        initializeData();
    }

    private By inputBox = By.id("search_input_text");
    private By cancelBtn = By.id("action_close");
    private By findListfist = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]");
    private By current_price = By.id("current_price");

    public SearchPage search(String keyword) {
        HashMap<String, Object> paramters = new HashMap<>();
        paramters.put("keyword", keyword);
        parseSteps(paramters);
//        findElement(inputBox).sendKeys(keyword);
//        click(findListfist);
        return this;
    }

    public void cancel() {
        //click(cancelBtn);
        parseSteps(null);
    }

    public Float getCurrentPrice() {
        //MobileElement el5 = (MobileElement) findElement(current_price);
        return Float.valueOf(parseSteps(null).get("price").toString());
        // return Float.valueOf(el5.getText());
    }
}
