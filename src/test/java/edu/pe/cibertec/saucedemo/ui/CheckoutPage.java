package edu.pe.cibertec.saucedemo.ui;

/** Selectors for the SauceDemo checkout flow. */
public final class CheckoutPage {

    private CheckoutPage() {
    }

    public static final String CHECKOUT_BUTTON = "[data-test='checkout']";
    public static final String FIRST_NAME = "[data-test='firstName']";
    public static final String LAST_NAME = "[data-test='lastName']";
    public static final String POSTAL_CODE = "[data-test='postalCode']";
    public static final String CONTINUE_BUTTON = "[data-test='continue']";
    public static final String CHECKOUT_FORM = "#checkout_info_container";
    public static final String ITEM_TOTAL = "[data-test='subtotal-label']";
    public static final String FINISH_BUTTON = "[data-test='finish']";
    public static final String CONFIRMATION_MESSAGE = "[data-test='complete-header']";
    public static final String ERROR_MESSAGE = "[data-test='error']";
}
