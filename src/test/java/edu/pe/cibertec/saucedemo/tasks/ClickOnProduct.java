package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;

/** English compatibility facade for {@link VerificarDetalle}. */
public class ClickOnProduct {

    public static Performable named(String productName) {
        return VerificarDetalle.delProducto(productName);
    }

}
