package edu.pe.cibertec.saucedemo.ui;

/** @deprecated Use {@link ProductosPage}. */
@Deprecated
public final class InventoryPage {
    private InventoryPage() {
    }

    public static final String PAGE_TITLE = ProductosPage.PAGE_TITLE;
    public static final String ORDER_PRODUCT_SELECT = ProductosPage.ORDER_PRODUCT_SELECT;
    public static final String FIRST_ITEM_PRICE = ProductosPage.FIRST_ITEM_PRICE;
    public static final String LAST_ITEM_PRICE = ProductosPage.LAST_ITEM_PRICE;

    public static String itemNameLink(String productName) {
        return ProductosPage.itemNameLink(productName);
    }
}
