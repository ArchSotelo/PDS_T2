package edu.pe.cibertec.saucedemo.ui;

/** Selectors for the SauceDemo cart and product actions. */
public final class CarritoPage {

    private CarritoPage() {
    }

    public static final String CART_LINK = "[data-test='shopping-cart-link']";
    public static final String CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String CART_ITEM_NAMES = "[data-test='inventory-item-name']";

    public static String addButtonFor(String productName) {
        return "[data-test='add-to-cart-" + productSlug(productName) + "']";
    }

    public static String removeButtonFor(String productName) {
        return "[data-test='remove-" + productSlug(productName) + "']";
    }

    private static String productSlug(String productName) {
        return productName.trim().toLowerCase().replaceAll("[^a-z0-9]+", "-");
    }
}
