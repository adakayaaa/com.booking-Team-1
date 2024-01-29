package pages.flights;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;

public class FlightsResultPage extends BasePage {

    @FindBy(css = "h3.display-4")
    private List<WebElement> titlesOfResultPage;

    @FindBy(xpath = "//div[@class='fare-item col-3 mt-5 active-fare ']//div[@class='d-block w-100 fs-5 text-muted']/span")
    private List<WebElement> pricesOfMain;


    public String getTitleOfResultPage(){
        return titlesOfResultPage.get(0).getText();
    }

    public int getPriceOfMainForDeparture(){
        List<Integer> list=pricesOfMain.stream().map(price -> Integer.parseInt(price.getText().substring(price.getText().indexOf("$") + 2))).toList();
        System.out.println(list.get(0));
        return list.get(0);

    }
    public int getPriceOfMainForArrival(){
        List<Integer> list=pricesOfMain.stream().map(price -> Integer.parseInt(price.getText().substring(price.getText().indexOf("$") + 2))).toList();
        System.out.println(list.get(1));
        return list.get(1);
    }

}
