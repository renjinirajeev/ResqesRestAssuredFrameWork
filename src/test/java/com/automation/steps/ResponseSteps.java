package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("user stores created request id into {string}")
    public void userStoresCreatedRequestIdInto(String key ) {
        ConfigReader.setConfig(key,RestAssuredUtils.getResponse().jsonPath().getString("id"));
    }

    @Then("verify booking id is not empty")
    public void verify_booking_id_is_not_empty() {
        String ResQesId= RestAssuredUtils.getFieldFromResponse("id");
        Assert.assertFalse(ResQesId.isEmpty());

    }


}
