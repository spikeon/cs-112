public class ProductDemo {
    public static Object findCheapest(Relatable[] arr){
        Relatable smallest = arr[0];
        for(Relatable object : arr) {
            if(object.lessThan(smallest)) smallest = object;
        }
        return smallest;
    }
    public static void main(String[] args){
        Relatable[] products = {
                new Product("Test", 4),
                new Product("Test 2", 2),
                new Product("Test 3", 6),
        };

        Relatable smallest = (Relatable) findCheapest(products);

        System.out.println(smallest);

    }
}
