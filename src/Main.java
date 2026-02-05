public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(46374544, "смартфон Samsung Galaxy S25 FE", 64999, "Смартфоны и гаджеты");
        Product product2 = new Product(66857418, "планшет HONOR Pad X9a", 25999, "Планшеты, электронные книги");
        Product product3 = new Product(96632143, "ноутбук HONOR MagicBook X16", 49999, "ПК, ноутбуки, периферия");

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        if (product2.equals(product3)) {
            System.out.println("это один и тот же товар.");
        }else {
            System.out.println("это разные товары.");
        }

        Product[]basket1={product1,product2};
        Product[]basket2={product1,product3,product3};
        Order order1=new Order("Вася", basket1 );
        Order order2=new Order("Петя", basket2);

        System.out.println(order1);
        System.out.println(order2);

        if (order1.equals(order2)) {
            System.out.println("это один и тот же заказ.");
        }else {
            System.out.println("это разные заказы.");
        }
    }
}