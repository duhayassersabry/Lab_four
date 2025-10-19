package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeUserDatabase implements abs2{
    private ArrayList<EmployeeUser> records;
    private String filename;
    public EmployeeUserDatabase(String filename){
        this.filename=filename;
        this.records=new ArrayList<>();
    }
    public void readFromFile(){
        records.clear();
        try(BufferedReader buf=new BufferedReader (new FileReader(filename))){
            String line;
            while((line=buf.readLine())!=null){
                EmployeeUser emp=createRecordFrom(line);
                if(emp!=null){
                    records.add(emp);
                }
            }
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    } 

    private EmployeeUser createRecordFrom(String line) {
        String[] parts=line.split(",");
        if(parts.length==5)
        {
            return new EmployeeUser(parts[0],parts[1],parts[2],parts[3],parts[4]);
        }else{
            System.out.println("Invalid line format : "+line);
            return null;
        }
    
    }
    public ArrayList<EmployeeUser> returnAllRecords() {
        return records;
    }
    public boolean contains(String key ) {
        for(EmployeeUser emp :records)
        {
         if(emp.getSearchKey().equals(key))
             return true;
        }
        return false;
    }
    public EmployeeUser getRecord(String key) {
        for(EmployeeUser emp :records)
        {
            if(emp.getSearchKey().equals(key))
                return emp;
        }
        return null;
        }
    public void insertRecord(EmployeeUser record){
        records.add(record);
    }
    public void deleteRecord(String key){
        for(int i=0;i<records.size();i++){
            if(records.get(i).getSearchKey().equals(key))
                records.remove(i);
            return;
        }
    }
    public void saveToFile() {
     try(PrintWriter pw=new PrintWriter(new FileWriter(filename,false))){
         for(EmployeeUser emp:records)
         {
             pw.println(emp.lineRepresentation());
         }
     }catch(IOException e){
     System.out.println("Error saving to file:"+e.getMessage());         
     }   
    }
}

