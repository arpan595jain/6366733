import java.util.*;

class Product {
    int id;
    String name;
    String category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return id + " " + name + " (" + category + ")";
    }
}

public class EcommerceSearchFunction {

    public static List<Product> linearSearch(List<Product> products, String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public static Product binarySearch(List<Product> sortedProducts, String targetName) {
        int low = 0, high = sortedProducts.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = sortedProducts.get(mid);
            int cmp = midProduct.name.compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return midProduct;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
            new Product(1, "Smartphone", "Electronics"),
            new Product(2, "Laptop", "Electronics"),
            new Product(3, "Smartwatch", "Accessories"),
            new Product(4, "Camera", "Electronics"),
            new Product(5, "Book", "Education")
        );

        // Linear Search
        System.out.println("Linear Search Results");
        List<Product> keywordMatches = linearSearch(productList, "smart");
        for (Product p : keywordMatches) {
            System.out.println(p);
        }

        // Binary Search
        System.out.println("Binary Search Results");
        List<Product> sortedList = new ArrayList<>(productList);
        sortedList.sort(Comparator.comparing(p -> p.name.toLowerCase()));

        String exactSearch = "Laptop";
        System.out.println( exactSearch);
        Product exactMatch = binarySearch(sortedList, exactSearch);

        if (exactMatch != null) {
            System.out.println( exactMatch);
        } else {
            System.out.println(" Product not found");
        }
    }
}
