package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Open;

/** Tasks and actor memory keys used by the advanced session scenarios. */
public final class VerificarSesion {

    public static final String LOGIN_DURATION_MILLIS = "login.duration.millis";
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";

    private VerificarSesion() {
    }

    public static Performable irAlCarrito() {
        return Task.where("{0} navigates to the cart page",
                Click.on(Target.the("Shopping cart")
                        .locatedBy(CarritoPage.CART_LINK)));
    }

    public static Performable volverAlCatalogo() {
        return Task.where("{0} navigates back to the inventory page",
                Open.url(INVENTORY_URL));
    }
}
