package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeUserDatabase {
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
        
    }
}
