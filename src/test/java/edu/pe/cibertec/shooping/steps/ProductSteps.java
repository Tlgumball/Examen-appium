package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheProductList;
import edu.pe.cibertec.shooping.tasks.FilterByCategory;
import edu.pe.cibertec.shooping.ui.ProductsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ProductSteps {
    @When("{word} selects the {string} category filter")
    public void selectsTheCategoryFilter(String actor, String category) {
        OnStage.theActorCalled(actor)
                .attemptsTo(FilterByCategory.of(category));
    }

    @Then("{word} should see the product {string}")
    public void should_see_the_product(String actor, String productName) {
        OnStage.theActorCalled(actor)
                .should(seeThat(TheProductList.contains(productName), equalTo(true)));
    }


    @Given("que el usuario esta en el catalogo")
    public void usuarioEnCatalogo() {
        theActorCalled("Estefano");
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(producto).into(ProductsScreen.TXT_SEARCH)
        );
    }

    @When("filtra los productos por la categoria {string}")
    public void filtraLosProductos(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                FilterByCategory.of(categoria)
        );
    }

    @Then("deberia ver productos que contienen {string}")
    public void verificarProducto(String esperado) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheProductList.contains(esperado)).isTrue()
        );
    }

    @Then("deberia ver solo productos de la categoria {string}")
    public void verificarCategoria(String categoria) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TheProductList.contains(categoria)).isTrue()
        );
    }

}
