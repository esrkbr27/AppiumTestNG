package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.n11Page;
import utilities.Driver;


public class n11Search {
     n11Page page=new n11Page();
    @Given("User navigate to n11")
    public void user_navigate_to_n11() {
        Driver.getDriver();
    }

    @And("User search {string}")
    public void userSearch(String item) {
      //   page.search.click();
      //   page.search.sendKeys(item);
    }
}
