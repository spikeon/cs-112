public abstract class Order {
    protected double subtotal = 0;
    protected double sales_tax = 0.08;

    public void addProduct(Product p) {
        subtotal += p.getPrice();
    }

    public abstract void applySale();

    public double getTotal(){
        applySale();
        return subtotal * (1 + sales_tax);
    }
}
