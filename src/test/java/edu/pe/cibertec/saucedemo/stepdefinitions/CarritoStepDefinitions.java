package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCart;
import edu.pe.cibertec.saucedemo.tasks.AbrirCarrito;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(productName));
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.elProducto(productName));
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String count) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.itemCount(), equalTo(count)));
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String firstProduct, String secondProduct) {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirCarrito.pagina());
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.productNames(), containsInAnyOrder(firstProduct, secondProduct)));
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(AbrirCarrito.pagina());
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.productNames(), equalTo(List.of(productName))));
    }
}
