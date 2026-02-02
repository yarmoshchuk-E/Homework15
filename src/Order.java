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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (!Objects.equals(customer, order.customer)) {
            return false;
        }
        if (basket == null && order.basket == null) {
            return true;
        }
        if (basket == null || order.basket == null) {
            return false;
        }
        if (basket.length != order.basket.length) {
            return false;
        }

        for (int i = 0; i < basket.length; i++) {

            if (basket[i] == null && order.basket[i] == null) {
                continue;
            }
            if (basket[i] == null || order.basket[i] == null) {
                return false;
            }
            if (!basket.equals(order.basket)) {
                return false;
            }
        }
        return true;
    }
}