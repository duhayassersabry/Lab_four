package main;
public class EmployeeUser {
   private String name;
   private String address;
   private String employeeId;
   private String phoneNumber;
   private String email;
   public EmployeeUser (String employeeId, String name, String email, String address,String phoneNumber){
       this.address=address;
       this.email=email;
       this.employeeId=employeeId;
       this.name=name;
       this.phoneNumber=phoneNumber;
   }
   public String lineRepresentation(){
       return employeeId+","+name+","+email+","+address+","+phoneNumber;
   } 
   public String getSearchKey(){
       return employeeId;
   }
}
