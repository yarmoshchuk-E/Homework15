import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    public String getCustomer() {
        return customer;
    }

    public Product[] getBasket() {
        return basket;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setBasket(Product[] basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Покупатель: " + getCustomer() + " " + Arrays.toString(basket);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;

        if (basket == null || order.basket == null) {
            return false;
        }
        if (basket.length == order.basket.length) {
            return true;
        }
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != order.basket[i]) {
                return false;
            }
        }
        return Objects.equals(customer, order.customer) && Arrays.equals(basket, order.basket);
    }
}