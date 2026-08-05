package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

/** Completes the checkout information and, when requested, submits the order. */
public final class CompletarCheckout {

    private CompletarCheckout() {
    }

    public static Performable conDatos(String firstName, String lastName, String postalCode) {
        return Task.where("{0} fills checkout information",
                Click.on(Target.the("Shopping cart").locatedBy(CarritoPage.CART_LINK)),
                Click.on(Target.the("Checkout button").locatedBy(CheckoutPage.CHECKOUT_BUTTON)),
                Enter.theValue(firstName).into(Target.the("First name").locatedBy(CheckoutPage.FIRST_NAME)),
                Enter.theValue(lastName).into(Target.the("Last name").locatedBy(CheckoutPage.LAST_NAME)),
                Enter.theValue(postalCode).into(Target.the("Postal code").locatedBy(CheckoutPage.POSTAL_CODE)),
                Click.on(Target.the("Continue button").locatedBy(CheckoutPage.CONTINUE_BUTTON)));
    }

    public static Performable elPedido() {
        return Task.where("{0} completes the order",
                Click.on(Target.the("Finish button").locatedBy(CheckoutPage.FINISH_BUTTON)));
    }
}
