package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.conDatos(firstName, lastName, postalCode));
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummaryShowsItemTotal(String total) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerificarResumen.totalDeItems(), equalTo(total)));
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(CompletarCheckout.elPedido());
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerificarResumen.confirmacion(), equalTo(message)));
    }

    @And("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerificarResumen.formularioVisible(), is(true)));
    }
}
