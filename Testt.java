package Testt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Testt {
    static String query;
    static String user = "admin";
    static String password = "admin";
    static String address = "jdbc:mysql://localhost:3306/test";
    static Connection connection;
    static Statement statement;

    public Testt() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            try {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("MySQL JDBC Driver loaded successfully.");
                } catch (ClassNotFoundException e) {
                    System.err.println("MySQL JDBC Driver not found.");
                    e.printStackTrace();
                    return;
                }

                connection = DriverManager.getConnection(address, user, password);
                statement = connection.createStatement();

                // *here we start the application*

                query = "CREATE TABLE IF NOT EXISTS Customers (customer_id INT NOT NULL AUTO_INCREMENT, " +
                        "first_name VARCHAR(30) NOT NULL," +
                        " last_name VARCHAR(30) NOT NULL," +
                        " email VARCHAR(30) NOT NULL," +
                        " phone INT NOT NULL," +
                        " city VARCHAR(15)," +
                        " CONSTRAINT pk1 PRIMARY KEY(customer_id))";

                statement.execute(query);
                System.out.println("Table 'Customers' created or already exists.");
                System.out.println("Enter the customer details:");
                System.out.print("Enter first name: ");
                String firstname = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastname = scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                System.out.print("Enter phone: ");
                int phone = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter city: ");
                String city = scanner.nextLine();

                query = "INSERT INTO Customers (first_name, last_name, email, phone, city) VALUES ('" + firstname + "', '" + lastname + "', '" + email + "', " + phone + ", '" + city + "')";
                statement.executeUpdate(query);
                System.out.println("Customer data inserted successfully.");
                query = "CREATE TABLE IF NOT EXISTS orders (order_id INT NOT NULL AUTO_INCREMENT," +
                        " order_status VARCHAR(30) NOT NULL," +
                        " order_type VARCHAR(30) NOT NULL," +
                        " customer_id INT," +
                        " FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
                        " CONSTRAINT pk2 PRIMARY KEY(order_id))";
                statement.execute(query);

                System.out.println("Table 'Orders' created or already exists.");
                System.out.println(" NOW Enter the orders details:");

                System.out.print("Enter order status: ");
                String order_status = scanner.nextLine();

                System.out.print("Enter order type: ");
                String order_type = scanner.nextLine();

                query = "INSERT INTO Customers ( order_status, order_type) VALUES ('" + order_status + "', '" + order_type + "')";

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
