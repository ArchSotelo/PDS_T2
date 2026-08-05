package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

/** Questions used to verify the checkout overview and confirmation. */
public final class VerificarResumen {

    private VerificarResumen() {
    }

    public static Question<String> totalDeItems() {
        return Text.of(Target.the("Item total").locatedBy(CheckoutPage.ITEM_TOTAL))
                .map(total -> total.replace("Item total:", "").trim());
    }

    public static Question<String> confirmacion() {
        return Text.of(Target.the("Order confirmation").locatedBy(CheckoutPage.CONFIRMATION_MESSAGE));
    }

    public static Question<Boolean> formularioVisible() {
        return net.serenitybdd.screenplay.playwright.questions.Visibility.of(
                Target.the("Checkout form").locatedBy(CheckoutPage.CHECKOUT_FORM));
    }
}
