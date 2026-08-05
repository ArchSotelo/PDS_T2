package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.ProductosPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

/** Opens a product detail page; its contents are asserted by Questions. */
public final class VerificarDetalle {

    private VerificarDetalle() {
    }

    public static Performable delProducto(String productName) {
        return Task.where("{0} opens product detail for '" + productName + "'",
                Click.on(Target.the("Product " + productName)
                        .locatedBy(ProductosPage.itemNameLink(productName))));
    }
}
