import java.time.LocalDate;

public class CustomerProduct {

    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;

        public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }
            public String getCustomerSSN() {

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
        public boolean isPaid() {

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String lineRepresentation() {
        return customerSSN + "," + productID + "," +
                String.format("%02d-%02d-%04d", purchaseDate.getDayOfMonth(), purchaseDate.getMonthValue(), purchaseDate.getYear()) +
                "," + paid;
    }

    public String getSearchKey() {
        return customerSSN + "," + productID + "," +
                String.format("%02d-%02d-%04d", purchaseDate.getDayOfMonth(), purchaseDate.getMonthValue(), purchaseDate.getYear());
    }
}
