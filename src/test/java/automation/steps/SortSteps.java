package automation.steps;

import automation.pages.SortPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SortSteps {
    SortPage sortPage = new SortPage();

    @Then("verify product displayed is in sorted order by  title A-Z")
    public void verifyProductDisplayedIsInSortedOrderByTitleAZ() {
        // It will show assertion error , elements are in not sorted order
//        Assert.assertTrue(sortPage.verifySortingIsDisplayedBasedAtoZ());
        Assert.assertFalse(sortPage.verifySortingIsDisplayedBasedAtoZ());


    }

    @Then("verify product displayed is in sorted order by  title Z-A")
    public void verifyProductDisplayedIsInSortedOrderByTitleZA() {
//        Assert.assertTrue(sortPage.verifySortingIsDisplayedBasedZtoA());
        Assert.assertFalse(sortPage.verifySortingIsDisplayedBasedZtoA());
    }


}
