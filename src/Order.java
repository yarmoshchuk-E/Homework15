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
        //Проверку Objects.equals(customer, order.customer) - поставить на первое место, перед проверкой на null basket'ов.
        if (Objects.equals(customer, order.customer)) {
            return true;
        }
        //Тебе следует проверить на НЕ совпадение длины массивов.
        if (basket.length != order.basket.length) {
            return false;
        }
        //Добавь проверку, если оба basket равны нулю - вернуть истину
        if (basket == null && order.basket == null) {
            return true;
        }

        for (int i = 0; i < basket.length; i++) {
            //Первая проверка - если элементы массива равны нулю оба, следует пропустить итерацию
            //(в массивах первые элементы отсутствуют, к примеру).
            if (basket[i] == null && order.basket[i] == null) {
                return true;                                        //
            }
            //Вторая проверка - если один из элементов равен null, а другой не равен null.
            if (basket[i] == null && order.basket[i] != null || basket[i] != null && order.basket[i] == null) {
                return false;
            }
            //Только после этого, тебе требуется проверить элементы не через == (как у тебя),
            //а через equals (p1.equals(p2)) т.к. это объекты.
            if (basket.equals(order.basket)) {
                return true;
            }
        }
        //Проверку Arrays.equals(basket, order.basket) - требуется убрать.
        //Вместо этих проверок, верни просто true: return true.
        return true;
    }
}