package management_system;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("UlianaCompany");

        Employee accountant1 = new Employee("Tim", "Tom", 2000);
        Employee accountant2 = new Employee("Tom", "Tim", 3000);
        company.addAccountant(accountant1);
        company.addAccountant(accountant2);


        Employee engineer = new Employee("Ihor", "Polishyk", 2300);
        company.addEngineer(engineer);
        //upgrade salary
        engineer.setSalary(2500);

        Employee manager1 = new Employee("Oleh", "White", 1340);
        Employee manager2 = new Employee("Pavlo", "Black", 5600);
        company.addManager(manager2);
        company.addManager(manager1);

        System.out.println(company.getTotalAmountByType(PositionType.ENGINEER));
        System.out.println(company.getTotalAmount());
    }

}
