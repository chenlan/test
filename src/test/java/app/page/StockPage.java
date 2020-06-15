package app.page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class StockPage extends BasePage {

    private By addSelfBtn = By.id("subscribe");
    private By stockList = By.id("portfolio_stockName");

    public StockPage deleteAll() {
        click(By.id("com.xueqiu.android:id/edit_group"));
        click(By.id("com.xueqiu.android:id/check_all"));
        click(By.id("com.xueqiu.android:id/cancel_follow"));
        click(By.id("com.xueqiu.android:id/tv_right"));
        click(By.id("com.xueqiu.android:id/action_close"));
        return this;
    }


    public StockPage addSelect() {
        click(addSelfBtn);
        return this;
    }

    public List<String> getStockList() {
        //handleAlert();
        List<String> stocks = new ArrayList<>();
        findElements(stockList).forEach(x -> {
            stocks.add(x.getText());
        });
        return stocks;
    }


}
