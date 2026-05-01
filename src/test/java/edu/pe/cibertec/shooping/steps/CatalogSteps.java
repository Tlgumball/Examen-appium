package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheProductList;
import edu.pe.cibertec.shooping.tasks.FilterByCategory;
import edu.pe.cibertec.shooping.ui.ScreenPlayCatalogPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CatalogSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario esta logueado en la aplicacion")
    public void usuarioLogueado() {
        theActorCalled("Estefano");
        // Aquí podrías llamar a una tarea de Login si fuera necesario
    }

    @Given("que el usuario esta en el catalogo")
    public void usuarioEnCatalogo() {
        theActorCalled("Estefano");
    }

    @When("navega al catalogo de productos")
    public void navegaAlCatalogo() {
        theActorInTheSpotlight().attemptsTo(
                // Acción para ir al catálogo
                Click.on(By.id("com.cibertec.shopping:id/nav_catalog"))
        );
    }

    @When("busca el producto {string}")
    public void buscaProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(producto).into(ScreenPlayCatalogPage.TXT_SEARCH)
        );
    }

    @When("filtra los productos por la categoria {string}")
    public void filtraPorCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                FilterByCategory.of(categoria)
        );
    }

    @Then("deberia ver la lista de productos disponibles")
    public void verListaDisponible() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ScreenPlayCatalogPage.LBL_PRODUCT_LIST).isDisplayed()
        );
    }

    @Then("deberia ver productos que contengan {string}")
    public void verificarBusqueda(String texto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheProductList.contains(texto)).isTrue()
        );
    }

    @Then("deberia ver solo productos de la categoria {string}")
    public void verificarFiltro(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheProductList.contains(categoria)).isTrue()
        );
    }

    @After
    public void drawTheCurtain() {
        OnStage.drawTheCurtain();
    }
}