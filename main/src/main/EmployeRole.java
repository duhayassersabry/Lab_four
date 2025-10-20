
package employeerole;
import java.time.LocalDate;

public class EmployeRole {
    
    private ProductDatabase PD;
    private CustomerProductDatabase CPD;
    
public EmployeRole() 
{
        PD = new ProductDatabase("Products.txt");
        CPD = new CustomerProductDatabase("CustomersProducts.txt");
}
        
public void addProduct(String productID, String productName, String 
manufacturerName, String supplierName, int quantity , float price)
{
    if (PD.contains(productID))
    {
        System.out.println("this Product: " + productName + "is Already exist.");
        return;
    }
    
     Product p = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        PD.insertRecord(p);
}
    
    public Product[] getListOfProducts() {
    
        return PD.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        return CPD.returnAllRecords().toArray(new CustomerProduct[0]);
    }
    
    
     public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product p = PD.getRecord(productID);
        if (p == null) return false;
        if (p.getQuantity() <= 0) return false;
        p.setQuantity(p.getQuantity() - 1);
        
        CustomerProduct cp = new CustomerProduct(customerSSN, productID, purchaseDate);
        CPD.insertRecord(cp);
        return true;
    }
     
     
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate ,LocalDate returnDate) 
    {
        if (returnDate.isBefore(purchaseDate)) return -1;
        Product p = PD.getRecord(productID);
        if (p == null) return -1;
        String key = customerSSN + "," + productID + "," + purchaseDate.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (!CPD.contains(key)) return -1;
        if (returnDate.isAfter(purchaseDate.plusDays(14)))
            return -1;
       // Otherwise -------------------------------------------------
        p.setQuantity(p.getQuantity() + 1);
        CPD.deleteRecord(key);
        return p.getPrice();
    }
    
public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {

  ArrayList<CustomerProduct> records = CPD.returnAllRecords();

    for (int i = 0; i < records.size(); i++) {
        CustomerProduct cp = records.get(i);

        if (cp.getCustomerSSN().equals(customerSSN) && cp.getPurchaseDate().equals(purchaseDate)) {
            if (!cp.isPaid()) {
                cp.setPaid(true);
                System.out.println("Paid successfully.");
                return true; 
            } 
            else {
                System.out.println("This payment is already paid");
                return false; 
                 }
        }
    }
        System.out.println("Invalid: There is no purchase !!");
    return false;
}

    public void logout()
     {
      PD.saveToFile();
      CPD.saveToFile();
      System.out.println("All data saved. Logging out.");
     }
}