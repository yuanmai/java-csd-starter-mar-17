package csd.starter.court;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by LTY on 2016/10/12.
 */
public class ReserveStepDefines {
    @Given("^i input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_input_and(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^the calculator is run$")
    public void the_calculator_is_run() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^the out put should be \"([^\"]*)\"$")
    public void the_out_put_should_be(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
