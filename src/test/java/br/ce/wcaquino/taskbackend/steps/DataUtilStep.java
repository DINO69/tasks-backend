package br.ce.wcaquino.taskbackend.steps;

import br.ce.wcaquino.taskbackend.utils.DateUtils;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Date;

public class DataUtilStep {

    private Date hoje;

    private Date dateParam;

    @ParameterType(".*")  // regexp
    public Date datee(String date){  // type, name (from method)
        return DateUtils.toDate(date);
    }

    @Given("que seja {datee}")
    public void queSeja(Date data) {
        dateParam = data;
    }

    @When("hoje for igual a {datee}")
    public void hojeForIgualA(Date data) {
        hoje = data;
    }
    @Then("data menor")
    public void dataMenor() {
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(dateParam,hoje));
    }

    @Then("data maior( ou igual)")
    public void dataMaior() {
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(dateParam,hoje));
    }

}
