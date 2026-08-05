package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.ProductosPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.SelectFromOptions;

/** Selects one of the sort options exposed by the product catalog. */
public final class OrdenarProductos {

    private OrdenarProductos() {
    }

    public static Performable por(String sortOption) {
        return Task.where("{0} sorts products by '" + sortOption + "'",
                SelectFromOptions.byVisibleText(sortOption)
                        .from(Target.the("Product sort selector")
                                .locatedBy(ProductosPage.ORDER_PRODUCT_SELECT)));
    }
}
