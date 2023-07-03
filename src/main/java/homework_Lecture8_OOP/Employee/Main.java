package homework_Lecture8_OOP.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(5, "Ivayla", "Slavova", 100);
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);

        double raisedSalary = employee.raiseSalary(10);
        annualSalary = employee.getAnnualSalary();
        System.out.println(employee);
    }
}
