public class AdminRole {

    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");
        database.readFromFile();
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        if (!database.contains(employeeId)) {
            EmployeeUser e = new EmployeeUser(employeeId, name, email, address, phoneNumber);
            database.insertRecord(e);
            database.saveToFile();
        }
    }

  