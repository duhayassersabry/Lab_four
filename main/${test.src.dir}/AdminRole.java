public class AdminRole {

    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("Employees.txt");
        database.readFromFile();
    }

