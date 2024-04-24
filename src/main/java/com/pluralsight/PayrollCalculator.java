package com.pluralsight;

import java.io.*;

public class PayrollCalculator {

    public static void main(String[] args) {
        String filename = "src/main/resources/employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                displayEmployee(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayEmployee(Employee employee) {
        System.out.printf("Employee ID: %d | Name: %s | Gross Pay: %.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
    }
}
