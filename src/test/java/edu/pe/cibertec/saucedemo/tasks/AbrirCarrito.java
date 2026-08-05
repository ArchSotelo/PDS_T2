package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

/** Opens the cart page. */
public final class AbrirCarrito {

    private AbrirCarrito() {
    }

    public static Performable pagina() {
        return Task.where("{0} opens the shopping cart",
                Click.on(Target.the("Shopping cart")
                        .locatedBy(CarritoPage.CART_LINK)));
    }
}
