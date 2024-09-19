package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BasePage {

    int numberOfStocks;

    String xpathForFilterTagName ="//android.widget.TextView[@resource-id='in.himalayawellness:id/filter_title' and @text='%s']";


    @FindBy(id = "in.himalayawellness:id/filter_value_checkbox")
    WebElement inStockElement;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/tvProductName']")
    List<WebElement> productNamesList;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='in.himalayawellness:id/parent'])[1]")
    WebElement scrollContainer;


    public void clicksOnFilterTags(String tagName) {
        WebElement filterTagName = driver.findElement(By.xpath(String.format(xpathForFilterTagName,tagName)));
        filterTagName.click();
    }

    public void clicksOnInStock() {
        numberOfStocks = Integer.parseInt((inStockElement.getText().split("\\(")[1]).split("\\)")[0]);
        System.out.println("Number of stocks : " + numberOfStocks);
        inStockElement.click();
    }

    public boolean isProductsDisplayedBasedOnInStock(){
        int x = scrollContainer.getLocation().getX();
        int y = scrollContainer.getLocation().getY();

        int scrollContainerWidth = scrollContainer.getSize().getWidth();
        int scrollContainerHeight = scrollContainer.getSize().getHeight();
        String productName1;
        String productName2;

        List<String> list1 = new ArrayList<>();

        String prevProductName = "";
        productName1 =productNamesList.get(0).getText();
        productName2 = productNamesList.get(1).getText();

        String currentProductName = productName1 + productName2;

        while (!currentProductName.equals(prevProductName)){
            for (WebElement productName : productNamesList) {
                if(!list1.contains(productName.getText()))
                {
                    list1.add(productName.getText());
                }
            }
            scrollOrSwipe((x + scrollContainerWidth) / 2, y + scrollContainerHeight, (x + scrollContainerWidth) / 2, y);

            prevProductName = currentProductName;
            productName1 =productNamesList.get(0).getText();
            productName2 = productNamesList.get(1).getText();

            currentProductName = productName1 + productName2;
        }
        int totalNumberOfProducts = list1.size();
        System.out.println("Total number of products after applying filter :"+totalNumberOfProducts);

        return totalNumberOfProducts == numberOfStocks;
    }

    public boolean isProductsDisplayedBasedOnProductType(String key) {
        int x = scrollContainer.getLocation().getX();
        int y = scrollContainer.getLocation().getY();

        int scrollContainerWidth = scrollContainer.getSize().getWidth();
        int scrollContainerHeight = scrollContainer.getSize().getHeight();
        String productName1;
        String productName2;

        List<String> list1 = new ArrayList<>();

        String prevProductName = "";
        productName1 =productNamesList.get(0).getText();
        productName2 = productNamesList.get(1).getText();

        String currentProductName = productName1 + productName2;

        while (!currentProductName.equals(prevProductName)){
            for (WebElement productName : productNamesList) {
                if(!list1.contains(productName.getText()))
                {
                    list1.add(productName.getText());
                }
            }
            scrollOrSwipe((x + scrollContainerWidth) / 2, y + scrollContainerHeight, (x + scrollContainerWidth) / 2, y);

            prevProductName = currentProductName;
            productName1 =productNamesList.get(0).getText();
            productName2 = productNamesList.get(1).getText();

            currentProductName = productName1 + productName2;
        }
        for(String li: list1){
            if(li.contains(key)){
                return true;            }
        }
        return false;
    }
}
