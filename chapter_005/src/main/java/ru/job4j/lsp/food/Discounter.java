package ru.job4j.lsp.food;

public class Discounter {
    private static final int DISCOUNT = 10;

    public void checkDiscount(Food product) {
            product.setDiscount(DISCOUNT);
            setNewPrice(product);
    }

    private void setNewPrice(Food product) {
        product.setPrice(product.getPrice() - (product.getPrice() * product.getDiscount() / 100));
    }
}
