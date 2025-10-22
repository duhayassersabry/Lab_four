package main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Use the existing Products.txt in the project root
        String filename = "Products.txt";
        ProductDatabase db = new ProductDatabase(filename);

        // 1) Read any existing records from file
        db.readFromFile();
        System.out.println("Initial records (after readFromFile):");
        for (Product p : db.returnAllRecords()) {
            System.out.println(p.lineRepresentation());
        }

        // 2) Pick a key from existing data (if any) and use contains/getRecord
        String key = null;
        if (!db.returnAllRecords().isEmpty()) {
            key = db.returnAllRecords().get(0).getSearchKey();
        } else {
            // If file is empty, demonstrate createRecordFrom() with a sample line (in-memory only)
            String sample = "S001,Sample,Maker,Supplier,3,9.99";
            Product sampleProd = db.createRecordFrom(sample);
            key = sampleProd.getSearchKey();
            // Exercise Product methods on this in-memory product
            System.out.println("\nCreated in-memory via createRecordFrom: " + sampleProd.lineRepresentation());
            System.out.println("Quantity before: " + sampleProd.getQuantity());
            sampleProd.setQuantity(sampleProd.getQuantity() + 2);
            System.out.println("Quantity after +2: " + sampleProd.getQuantity());
        }

        // contains() and getRecord() against the chosen key (only if present in DB)
        System.out.println("\ncontains(" + key + ") = " + db.contains(key));
        Product found = db.getRecord(key);
        if (found != null) {
            System.out.println("getRecord(" + key + ") = " + found.lineRepresentation());
            // Demonstrate quantity decrease then increase (in-memory only)
            int q0 = found.getQuantity();
            found.setQuantity(q0 - 1);
            System.out.println("After decrease by 1: " + found.lineRepresentation());
            found.setQuantity(found.getQuantity() + 2);
            System.out.println("After increase by 2: " + found.lineRepresentation());
        }

        // 3) Exercise insertRecord and deleteRecord WITHOUT saving to file
        //    Create a temp product, insert it, show it's present, then delete it
        Product temp = new Product("TMP001", "Temp", "Maker", "Supplier", 1, 1.0f);
        if (!db.contains(temp.getSearchKey())) {
            db.insertRecord(temp);
            System.out.println("\nInserted temp in-memory: " + temp.lineRepresentation());
        }
        System.out.println("Contains TMP001 after insert: " + db.contains("TMP001"));
        db.deleteRecord("TMP001");
        System.out.println("Contains TMP001 after delete: " + db.contains("TMP001"));

        // 4) Final print of in-memory records (no file writes performed)
        System.out.println("\nFinal in-memory records (file unchanged):");
        for (Product p : db.returnAllRecords()) {
            System.out.println(p.lineRepresentation());
        }
    }
}
