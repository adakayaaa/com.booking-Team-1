package step_defs.hotels;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import step_defs.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class HotelsConfirmationPageStepDefs extends BaseStep {

    Logger logger = LogManager.getLogger(HotelsConfirmationPageStepDefs.class);

    @Then("The user should see confirmation message as {string}")
    public void theUserShouldSeeConfirmationMessageAs(String confirmationMessage) {
        then(PAGES.getHotelsConfirmationPage().getConfirmationMessage())
                .withFailMessage("Confirmation message is not displayed properly").isEqualTo(confirmationMessage);
    }

    @When("The user clicks on close button")
    public void theUserClicksOnCloseButton() {
        PAGES.getHotelsConfirmationPage().clicksOnCloseButton();
        logger.info("The user clicked on close button");
    }
}
