package main;

public class Product implements abs1 {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String name)
    {
        this.productName=name;
    }
    public String getManufacturerName()
    {
        return manufacturerName;
    }
    public void setManufactureName(String manufacturername)
    {
        this.manufacturerName=manufacturername;
    }
    public String getSupplierName()
    {
        return supplierName;
    }
    public void setSupplierName(String sname)
    {
        this.supplierName=sname;
    }
    public String getProductID()
    {
        return productID;
    }
    public void setparoductID(String productid)
    {
        this.productID=productid;
    }
    public float getPrice()
    {
        return price;
    }
    public void setPrice(float p)
    {
        this.price=p;
    }

    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + "," + price;
    }

    public String getSearchKey() {
        return productID;
    }
    public boolean takeUnit() {
        if (quantity > 0) {
            quantity--;
            return true;  
        } else {
            System.out.println("No units available for product: " + productID);
            return false;
        }
    }
      public void returnUnit() {
        quantity++;
    }
}
