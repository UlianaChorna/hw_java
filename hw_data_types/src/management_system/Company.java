package management_system;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees;

    private String name;

    public Company(String name) {
        this.employees = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmount() {
        return  getTotalAmount(this.employees);
    }

    public double getTotalAmountByType(PositionType type) {
        List<Employee> employeeByType = new ArrayList<>();

        for (Employee employee : this.employees) {
            if (type == employee.getPosition()) {
                employeeByType.add(employee);
            }
        }

        return  getTotalAmount(employeeByType);
    }

    public void addEngineer(Employee employee) {
        addEmployee(employee, PositionType.ENGINEER);
    }

    public void addManager(Employee employee) {
        addEmployee(employee, PositionType.MANAGER);
    }
    public void addAccountant(Employee employee) {
        addEmployee( employee, PositionType.ACCOUNTANT);
    }


    private double getTotalAmount(List<Employee> employees) {
        double totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.getSalary();
        }

        return  totalAmount;
    }

    private void addEmployee(Employee employee, PositionType position) {
        employee.setPosition(position);

        employees.add(employee);
    }

}
