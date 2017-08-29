public class DiscountOrder extends Order {
    private double off;
    public DiscountOrder(double off){
        this.off = off;
    }
    public void applySale(){
        subtotal -= off;
    }
}
