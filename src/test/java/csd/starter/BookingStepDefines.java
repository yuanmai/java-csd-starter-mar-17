package csd.starter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by shenzx on 3/5/17.
 */
public class BookingStepDefines {

    @Given("^\"([^\"]*)\" booking \"([^\"]*)\" court between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void booking_court_between_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        System.out.println("arg1=" + arg1);
        System.out.println("arg2=" + arg2);
        System.out.println("arg3=" + arg3);
        System.out.println("arg4=" + arg4);

    }

    @When("^the Reservator is run, and return true$")
    public void the_Reservator_is_run_and_return_true() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^the output \"([^\"]*)\"$")
    public void the_output(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
