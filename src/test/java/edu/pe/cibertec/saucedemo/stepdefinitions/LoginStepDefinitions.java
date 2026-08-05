package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import com.microsoft.playwright.Page;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginStepDefinitions {

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        long start = System.currentTimeMillis();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
        long elapsed = System.currentTimeMillis() - start;
        OnStage.theActorInTheSpotlight().remember(VerificarSesion.LOGIN_DURATION_MILLIS, elapsed);
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        Page page = currentPage();
        assertThat(page.locator("[data-test='title']")).isVisible();
        assertThat(page.locator("[data-test='title']")).containsText("Products");
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("the page load time should be greater than {int} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThan(long thresholdMillis) {
        Long elapsed = OnStage.theActorInTheSpotlight().recall(VerificarSesion.LOGIN_DURATION_MILLIS);
        org.assertj.core.api.Assertions.assertThat(elapsed).isGreaterThan(thresholdMillis);
    }

    @And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(VerificarSesion.irAlCarrito());
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(VerificarSesion.volverAlCatalogo());
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn() {
        Page page = currentPage();
        assertThat(page.locator("[data-test='title']")).isVisible();
        assertThat(page.locator("[data-test='title']")).containsText("Products");
    }

    private Page currentPage() {
        return BrowseTheWebWithPlaywright.as(
                OnStage.theActorInTheSpotlight()).getCurrentPage();
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

}
