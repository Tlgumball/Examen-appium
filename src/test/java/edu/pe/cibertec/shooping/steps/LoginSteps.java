package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.LoginScreen;
import edu.pe.cibertec.shooping.ui.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {
    private String email;
    private String password;

    @Given("Andrea opens the shopping Cart application")
    public void opensTheShoopingCartApplication() {
        OnStage.theActorCalled("Andrea");
    }


    @When("she enters her email {string} and password {string}")
    public void entersHerEmailAndPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @And("she taps the Login button")
    public void tapsTheLoginButton() {
        theActorInTheSpotlight()
                .attemptsTo(Login.withCredentials(email, password));
    }

    @Then("she should see the main screen of the application")
    public void checksTheMainScreen() {
        theActorInTheSpotlight().attemptsTo(
                // Requerimiento (c): Validación real con Ensure
                Ensure.that(ProfilePage.BTN_USER_MENU).isDisplayed()
        );
    }


    @Then("she should see an error message")
    public void checksErrorMessage() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginScreen.LBL_ERROR_MESSAGE).isDisplayed()
        );
    }

}