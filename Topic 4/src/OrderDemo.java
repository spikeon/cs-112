public class OrderDemo {
    public static void main(String[] args) {
        Product p1 = new Product("iPhone", 700);
        Product p2 = new Product("Cheeseburger", 3);
        Product p3 = new Product("Disneyland Ticket", 120);

        Order order1 = new TaxFreeOrder();
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p3);

        Order order2 = new DiscountOrder(20);
        order2.addProduct(p1);
        order2.addProduct(p2);
        order2.addProduct(p3);

        System.out.println("Order 1 total: " + order1.getTotal());
        System.out.println("Order 2 total: " + order2.getTotal());
    }
}
