public class Product implements Relatable {
        private String name;
        private double price;

        public Product(String n, double p) {
            name = n;
            price = p;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name + " (price: " + price + ")";
        }

        public boolean lessThan(Object other) {
            if(!(other instanceof Product)) return false;
            return price < ((Product) other).price;
        }
}
