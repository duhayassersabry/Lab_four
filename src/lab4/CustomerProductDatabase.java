
package lab4;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;


public class CustomerProductDatabase {
    
    private String filename;
    private ArrayList<CustomerProduct> records = new ArrayList<>();
    
    public CustomerProductDatabase (String filename) 
    {
    this.filename = filename;
    }
    
    public void readFromFile() {
        records.clear();
        File f = new File(filename);
        if (!f.exists()) {
            try { f.createNewFile(); }
            catch (IOException e) { System.err.println("Cannot create " + filename); }
            return;
        }
    try (BufferedReader br = new BufferedReader( new FileReader(f)) ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                CustomerProduct cp = createRecordFrom(line);
                if (cp != null) records.add(cp);
            }
        } catch (IOException e) {
            System.err.println("Error reading " + filename + ": " + e.getMessage());
        }
    }
    
    public CustomerProduct createRecordFrom(String line)
    {
    String[] parts = line.split(",");
    
    if (parts.length < 4)
        return null;
    try{
     String ssn = parts[0].trim();
     String P_id = parts[1].trim();
     
            LocalDate date = CustomerProduct.parseDateString(parts[2].trim());
            boolean paid = Boolean.parseBoolean(parts[3].trim());
            CustomerProduct cp = new CustomerProduct(ssn, P_id, date);
            cp.setPaid(paid);
            return cp;
        } catch (Exception e) {
            return null;
        }
}
    
        public ArrayList<CustomerProduct> returnAllRecords()
        { 
            return records; 
        }
        
        public boolean contains(String key )
        {
            
        for (int i = 0; i < records.size(); i++) {
        CustomerProduct cp = records.get(i);
        if (cp.getSearchKey().equals(key)) 
            return true;
    }
        return false;
        } 
        
        
        public CustomerProduct getRecord(String key)
        {
        if (contains(key))
        return  createRecordFrom(key);
        else
            return null;
        }
        
       public void insertRecord(CustomerProduct record)
        {
            if ( !contains(record.getSearchKey()) )
        records.add(record)  ;
            else 
System.out.println("Invalid Record: already exists.");
        }
       
       
       public void deleteRecord(String key)
       {
           
       if ( contains(key) )
       {
       records.remove(createRecordFrom(key))  ;
       }
            else 
System.out.println("Invalid proccess: It's not exists.");
       }
       
 }

    
