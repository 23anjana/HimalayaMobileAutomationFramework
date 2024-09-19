package automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='in.himalayawellness:id/tvProductName']")
    List<WebElement> productNamesList;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='in.himalayawellness:id/parent'])[1]")
    WebElement scrollContainer;


    public boolean verifySortingIsDisplayedBasedAtoZ() {
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

        System.out.println(currentProductName);


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
        System.out.println("Original List ,A to Z :\n\n" + list1);

        // Create a copy of list 1
        List<String> list2 = new ArrayList<>(list1);

        // Reversing the list 2
        Collections.reverse(list2);
//        System.out.println("Reverse List ,Z to A :\n" + list2);

        //Sorting the list 2
        Collections.sort(list2);
//        System.out.println("Sorted List ,A to Z :\n" + list2);

        return list1.equals(list2);
    }

    public boolean verifySortingIsDisplayedBasedZtoA() {
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

        System.out.println(currentProductName);


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
        System.out.println("Original List ,Z to A :\n\n" + list1);

        // Create a copy of list 1
        List<String> list2 = new ArrayList<>(list1);

        //Sorting the list 2
        Collections.sort(list2);
//        System.out.println("Sorted List ,A to Z :\n" + list2);

        // Reversing the list 2
        Collections.reverse(list2);
//        System.out.println("Reverse List ,Z to A :\n" + list2);

        return list1.equals(list2);
    }
}
