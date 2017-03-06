package com.reserve;

import csd.starter.Main;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.*;

/**
 * Created by linyihang on 2017/3/5.
 */
public class ReserveStepDefines {

    @Given("^i input \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_input_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();

        String in = arg1 + " " + arg2 + " " + arg3 + " " + arg4;
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
        System.setOut(new PrintStream(baos));
        Main.main(null);
        System.setIn(oldIn);
        System.setOut(oldOut);
        content = baos.toString();
    }

    @When("^no others subcibed$")
    public void no_others_subcibed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @When("^area \"([^\"]*)\" during \"([^\"]*)\" and \"([^\"]*)\" had been subcibed$")
    public void area_during_time_had_been_subcibed(String arg1, String arg2, String arg3) throws Throwable {
        String in = "admin" + " " + arg2 + " " + arg3 + " " + arg1 + " ";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
        System.setOut(new PrintStream(baos));
        Main.main(null);
        System.setIn(oldIn);
        System.setOut(oldOut);
        Assert.assertEquals("OK", oldOut);
    }

    @Then("^the out put should be \"([^\"]*)\"$")
    public void the_out_put_should_be(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Assert.assertEquals(arg1, content);
        System.out.println(content);

        String in = "exit";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
        System.setOut(new PrintStream(baos));
        Main.main(null);
        System.setIn(oldIn);
        System.setOut(oldOut);
        Assert.assertEquals("bye~", oldOut);
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream oldIn = System.in;
    PrintStream oldOut = System.out;
    String content;
}
