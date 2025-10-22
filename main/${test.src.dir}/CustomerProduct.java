import java.time.LocalDate;

public class CustomerProduct {

    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;

        public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }



}