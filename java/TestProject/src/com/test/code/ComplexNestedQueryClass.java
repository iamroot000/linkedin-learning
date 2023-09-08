package com.test.code;

import java.sql.*;

public class ComplexNestedQueryClass {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/DummyDB";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Query 1
            final String query1 = "SELECT age, "
                    + "COUNT(*) as count, "
                    + "AVG(salary) as avg_salary "
                    + "FROM DummyTable "
                    + "WHERE (age > 25 AND age < 40) OR (salary > 60000) "
                    + "GROUP BY age "
                    + "HAVING count > 2 "
                    + "ORDER BY avg_salary DESC";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query1)) {
                while (resultSet.next()) {
                    int age = resultSet.getInt("age");
                    int count = resultSet.getInt("count");
                    double avgSalary = resultSet.getDouble("avg_salary");

                    System.out.println("Query 1 - Age: " + age + ", Count: " + count + ", Average Salary: " + avgSalary);
                }
            }

            // Query 2
            final String query2 = "SELECT department, "
                    + "COUNT(*) as employee_count, "
                    + "MAX(salary) as max_salary "
                    + "FROM EmployeeTable "
                    + "GROUP BY department "
                    + "HAVING employee_count > 5 "
                    + "ORDER BY max_salary DESC";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query2)) {
                while (resultSet.next()) {
                    String department = resultSet.getString("department");
                    int employeeCount = resultSet.getInt("employee_count");
                    double maxSalary = resultSet.getDouble("max_salary");

                    System.out.println("Query 2 - Department: " + department + ", Employee Count: " + employeeCount + ", Max Salary: " + maxSalary);
                }
            }

            // Query 3
            final String query3 = "SELECT city, "
                    + "COUNT(*) as population "
                    + "FROM PopulationTable "
                    + "GROUP BY city "
                    + "HAVING population > 1000000 "
                    + "ORDER BY population DESC";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query3)) {
                while (resultSet.next()) {
                    String city = resultSet.getString("city");
                    int population = resultSet.getInt("population");

                    System.out.println("Query 3 - City: " + city + ", Population: " + population);
                }
            }

            // Query 4
            final String query4 = "SELECT product_name, "
                    + "SUM(quantity_sold) as total_quantity "
                    + "FROM SalesTable "
                    + "GROUP BY product_name "
                    + "HAVING total_quantity > 100 "
                    + "ORDER BY total_quantity DESC";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query4)) {
                while (resultSet.next()) {
                    String productName = resultSet.getString("product_name");
                    int totalQuantity = resultSet.getInt("total_quantity");

                    System.out.println("Query 4 - Product Name: " + productName + ", Total Quantity Sold: " + totalQuantity);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

