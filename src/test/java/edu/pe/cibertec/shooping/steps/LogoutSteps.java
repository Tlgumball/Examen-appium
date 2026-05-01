package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.LoginScreen;
import edu.pe.cibertec.shooping.ui.ProfilePage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LogoutSteps {

    @Given("que el usuario esta logueado en la aplicacion")
    public void usuarioLogueado() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProfilePage.BTN_USER_MENU).isDisplayed()
        );
    }

    @When("hace clic en el menu de usuario")
    public void clicEnMenu() {
        theActorInTheSpotlight().attemptsTo(Click.on(ProfilePage.BTN_USER_MENU));
    }

    @And("hace clic en cerrar sesion")
    public void clicCerrarSesion() {
        theActorInTheSpotlight().attemptsTo(Click.on(ProfilePage.BTN_LOGOUT));
    }

    @Then("deberia regresar a la pantalla de login")
    public void validarRegresoAlLogin() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginScreen.LOGIN_BUTTON).isDisplayed()
        );
    }
}