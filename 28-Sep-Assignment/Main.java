package org.example.DAOassignment;

import org.example.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Company c = new Company();

        char choice = 'Y';
        do {
            System.out.println("1. Add Employee Details");
            System.out.println("2. Show All Employee");
            System.out.println("3. Select Employee by Id");
            System.out.println("4. Modify Employee Details");
            System.out.println("5. Delete Employee Details");

            System.out.println("Enter your Option");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter employee id, employee name, employee salary, Department,Manager name");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int salary = sc.nextInt();
                    String department = sc.next();
                    String manager = sc.next();
                    c.addEmployeeDetails(new Employee(id, name, salary, department, manager));
                    break;
                case 2:
                    c.displayAllEmployeeDetails();
                    break;

                case 3:
                    System.out.println("Enter employee id");
                    id = sc.nextInt();
                    c.displayEmployeeDetailsById(id);
                    break;

                case 4:
                    System.out.println("Enter employee id, employee name, employee salary, Manager name");
                    id = sc.nextInt();
                    name = sc.next();
                    salary = sc.nextInt();
                    department = sc.next();
                    manager = sc.next();
                    c.modifyEmployeeDetails(new Employee(id, name, salary, department, manager));
                    break;

                case 5:
                    System.out.println("Enter employee id");
                    id = sc.nextInt();
                    c.deleteEmployeeDetails(id);
                    break;
            }
            System.out.println("Do you want to continue Y/N");
            choice = sc.next().charAt(0);
        }
            while ( choice == 'Y' || choice == 'y') ;
        System.out.println("Exited");

    }
}
