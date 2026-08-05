package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

/** Adds a named product from the inventory page to the cart. */
public final class AgregarAlCarrito {

    private AgregarAlCarrito() {
    }

    public static Performable elProducto(String productName) {
        return Task.where("{0} adds '" + productName + "' to the cart",
                Click.on(Target.the("Add " + productName + " to cart")
                        .locatedBy(CarritoPage.addButtonFor(productName))));
    }
}
