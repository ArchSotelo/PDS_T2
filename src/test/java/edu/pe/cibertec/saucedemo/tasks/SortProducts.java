package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;

/** English compatibility facade for {@link OrdenarProductos}. */
public class SortProducts {

    public static Performable by(String sortOperation) {
        return OrdenarProductos.por(sortOperation);
    }

}
