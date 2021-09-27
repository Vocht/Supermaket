import items.Apple;
import items.Orange;
import items.SupermarketItem;

public class Supermarket {
    private final ShoppingCart shoppingCart = new ShoppingCart();

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void checkOut(Wallet wallet) {
        wallet.reduceBalance(shoppingCart.getTotalPrice());
        shoppingCart.emptyCart();
    }

    public void addToCart(SupermarketItem item) {
        shoppingCart.addItem(item);
    }

    public void addToCart(SupermarketItem... items) {
        shoppingCart.addItems(items);
    }
}
