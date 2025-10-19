package main;
public class Main {

 public static void main(String[] args) {
    ProductDatabase db = new ProductDatabase("Products.txt");
    db.readFromFile();
    System.out.println("All records:");
    for (Product p : db.returnAllRecords()) {
        System.out.println(p.lineRepresentation());

    String key = "P2394";
    System.out.println("Contains " + key + ": " + db.contains(key));
    Product found = db.getRecord(key);
    if (found != null) {
        System.out.println("Found: " + found.lineRepresentation());
    } else {
        System.out.println("Not found: " + key);
    }
 }
}}
