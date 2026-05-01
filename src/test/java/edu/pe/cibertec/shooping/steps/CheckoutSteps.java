package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import edu.pe.cibertec.shooping.ui.ShippingPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CheckoutSteps {

    @Given("que el usuario tiene productos en el carrito")
    public void usuarioConProductos() {
        theActorCalled("Estefano");
    }

    @When("procede al checkout")
    public void irAlCheckout() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnCart"))
        );
    }

    @And("ingresa los datos de envio")
    public void ingresarDireccion() {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue("Calle Cibertec 123").into(ShippingPage.TXT_ADDRESS),
                Click.on(ShippingPage.BTN_NEXT)
        );
    }

    @And("confirma la compra")
    public void confirmar() {
        theActorInTheSpotlight().attemptsTo(Click.on(CheckoutPage.BTN_CONFIRM));
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void validarExito() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CheckoutPage.LBL_SUCCESS).isDisplayed()
        );
    }

    @Given("que el usuario tiene el carrito vacio")
    public void usuarioCarritoVacio() {
        theActorCalled("Estefano");
    }

    @When("intenta proceder al checkout")
    public void intentarCheckoutVacio() {
        theActorInTheSpotlight().attemptsTo(Click.on(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnCart")));
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void validarMensajeVacio() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CheckoutPage.LBL_EMPTY_ERROR).isDisplayed()
        );
    }

    @And("intenta confirmar la compra sin direccion")
    public void confirmarSinDireccion() {
        theActorInTheSpotlight().attemptsTo(Click.on(CheckoutPage.BTN_CONFIRM));
    }

    @Then("deberia ver un mensaje de advertencia solicitando direccion")
    public void validarErrorDireccion() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ShippingPage.LBL_ADDRESS_ERROR).isDisplayed()
        );
    }

}