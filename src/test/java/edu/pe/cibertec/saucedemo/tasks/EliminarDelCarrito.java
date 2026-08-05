package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

/** Removes a named product from the cart. */
public final class EliminarDelCarrito {

    private EliminarDelCarrito() {
    }

    public static Performable elProducto(String productName) {
        return Task.where("{0} removes '" + productName + "' from the cart",
                Click.on(Target.the("Remove " + productName + " from cart")
                        .locatedBy(CarritoPage.removeButtonFor(productName))));
    }
}
