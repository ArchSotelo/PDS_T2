package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

import java.util.List;

public final class TheCart {

    private TheCart() {
    }

    public static Question<String> itemCount() {
        return Text.of(Target.the("Cart item count")
                .locatedBy(CarritoPage.CART_BADGE));
    }

    public static Question<List<String>> productNames() {
        return Text.ofEach(Target.the("Cart product names")
                .locatedBy(CarritoPage.CART_ITEM_NAMES));
    }
}
