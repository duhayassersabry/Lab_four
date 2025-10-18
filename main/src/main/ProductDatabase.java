package main;

import java.io.*;
import java.util.ArrayList;

public class ProductDatabase {

    private ArrayList<Product> records;
    private String filename;

    public ProductDatabase(String filename) {
        this.filename=filename;
        this.records=new ArrayList<>();
    }
    public void readFromFile()
    {
        records.clear();
        try(BufferedReader br= new BufferedReader(new FileReader(filename)))
        {
            String line;
            while((line=br.readLine())!= null)
            {
                Product p=createRecordFrom(line);
                records.add(p);
            }
        }catch(IOException e)
        {
            System.out.println("Error reading from file:"+ e.getMessage());
        }
        
    }
    public Product createRecordFrom(String line)
    {
        String[] parts=line.split(",");
        String id=parts[0];
        String name=parts[1];
        String manfacturer=parts[2];
        String supplier=parts[3];
        int quantity=Integer.parseInt(parts[4]);
        float price=Float.parseFloat(parts[5]);
        return new Product(id,name,manfacturer,supplier,quantity,price);
        
    }
    
    public ArrayList<Product> returnAllRecords()
    {
        return records;
    }
    public boolean contains(String key)
    {
        for(Product p:records)
        {
            if(p.getSearchKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }
    
    public Product getRecord(String key)
    {
        for(Product p:records)
        {
            if(p.getSearchKey().equals(key))
            {
                return p;
            }
        }
        return null;
    }
    
    public void insertRecord(Product record)
    {
        records.add(record);
    }
    
    public void deleteRecord(String key)
    {
        Product toDelete=null;
        for(Product p:records)
        {
            if(p.getSearchKey().equals(key))
            {
                toDelete=p;
                break;
            }
        }
        if(toDelete!=null)
        {
            records.remove(toDelete);
        }
    }
    
    public void saveToFile()
    {
        try(PrintWriter pw= new PrintWriter(new FileWriter(filename)))
        {
            for(Product p:records)
            {
                pw.println(p.lineRepresentation());
            }
        }catch(IOException e)
                {
                System.out.println("Error writing to file:"+ e.getMessage());
                }
    }
}
