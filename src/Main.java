import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Retrieve data from DB -- using SELECT query
            // -------------------------------------------
            // String query = "SELECT * FROM students;";
            // ResultSet resultSet = statement.executeQuery(query);
            // while (resultSet.next()) {
            //     int id = resultSet.getInt("id");
            //     String name = resultSet.getString("name");
            //     int age = resultSet.getInt("age");
            //     double marks = resultSet.getDouble("marks");
            //     System.out.println("ID: " + id);
            //     System.out.println("Name: " + name);
            //     System.out.println("Age: " + age);
            //     System.out.println("Marks: " + marks);
            //     System.out.println("-------------------");
            // }

            // Insert data in the DB -- using INSERT query
            // -------------------------------------------
            // String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %o, %f);", "Haseeb", 24, 90.6);
            // int rowsAffected = statement.executeUpdate(query);
            // if (rowsAffected > 0) {
            //     System.out.println("Data inserted successfully!");
            // } else {
            //     System.out.println("Data not inserted!");
            // }

            // Update data in the DB -- using UPDATE query
            // -------------------------------------------
            // String query = String.format("UPDATE students SET marks = %f WHERE id = %d;", 97.7, 2);
            // int rowsAffected = statement.executeUpdate(query);
            // if (rowsAffected > 0) {
            //     System.out.println("Data updated successfully!");
            // } else {
            //     System.out.println("Data not updated!");
            // }

            // Delete data from the DB -- using DELETE query
            // ---------------------------------------------
            // String query = String.format("DELETE FROM students WHERE id = %d;", 2);
            // int rowsAffected = statement.executeUpdate(query);
            // if (rowsAffected > 0) {
            //     System.out.println("Data deleted successfully!");
            // } else {
            //     System.out.println("Data not deleted!");
            // }

            // Using PreparedStatement interface to insert data -- Using INSERT query
            // ----------------------------------------------------------------------
            // String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?);";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setString(1, "Hamza");
            // preparedStatement.setInt(2, 24);
            // preparedStatement.setDouble(3, 89.5);
            // int rowsAffected = preparedStatement.executeUpdate();
            // if (rowsAffected > 0) {
            //     System.out.println("Data Inserted Successfully!");
            // } else {
            //     System.out.println("Data insertion failed!");
            // }

            // Using PreparedStatement Interface to retrieve data -- Using SELECT query
            // ------------------------------------------------------------------------
            // String query = "SELECT * FROM students WHERE id = ?;";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setInt(1, 1);
            // ResultSet resultSet = preparedStatement.executeQuery();
            // while (resultSet.next()) {
            //     int id = resultSet.getInt("id");
            //     String name = resultSet.getString("name");
            //     int age = resultSet.getInt("age");
            //     double marks = resultSet.getDouble("marks");
            //     System.out.println("ID: " + id);
            //     System.out.println("NAME: " + name);
            //     System.out.println("AGE: " + age);
            //     System.out.println("MARKS: " + marks);
            //     System.out.println("----------------");
            // }

            // Using PreparedStatement Interface to update data -- using UPDATE query
            // ----------------------------------------------------------------------
            // String query = "UPDATE students SET name = ? WHERE id = ?;";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setString(1, "Muhammad Saleh");
            // preparedStatement.setInt(2, 1);
            // int rowsAffected = preparedStatement.executeUpdate();
            // if (rowsAffected > 0) {
            //     System.out.println("Data Updated Successfully!");
            // } else {
            //     System.out.println("Data not Updated!");
            // }

            // Using PreparedStatement Interface to delete data -- using DELETE query
            // ----------------------------------------------------------------------
            // String query = "DELETE FROM students WHERE id = ?;";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // preparedStatement.setInt(1, 3);
            // int rowsAffected = preparedStatement.executeUpdate();
            // if (rowsAffected > 0) {
            //     System.out.println("Data Deleted Successfully!");
            // } else {
            //     System.out.println("Data not Deleted!");
            // }

            // Batch processing
            // ----------------
            // Scanner scanner = new Scanner(System.in);
            // while (true) {
            //     System.out.print("Enter name: ");
            //     String name = scanner.next();

            //     System.out.print("Enter age: ");
            //     int age = scanner.nextInt();

            //     System.out.print("Enter marks: ");
            //     double marks = scanner.nextDouble();

            //     String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f);", name, age, marks);

            //     statement.addBatch(query);

            //     System.out.println("Enter more data(y/n): ");
            //     String choice = scanner.next();

            //     if (choice.equalsIgnoreCase("N")) {
            //         break;
            //     }
            // }

            // int[] rowsAffected = statement.executeBatch();
            // for (int i = 0; i < rowsAffected.length; i++) {
            //     if (rowsAffected[i] == 0) {
            //         System.out.println("Query: " + i + " failed to execute successfully!");
            //     }
            // }

            // Batch processing using PreparedStatement Interface
            // --------------------------------------------------
            // Scanner scanner = new Scanner(System.in);
            // String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?);";
            // PreparedStatement preparedStatement = connection.prepareStatement(query);

            // while (true) {
            //     System.out.print("Enter name: ");
            //     String name = scanner.next();

            //     System.out.print("Enter age: ");
            //     int age = scanner.nextInt();

            //     System.out.print("Enter marks: ");
            //     double marks = scanner.nextDouble();

            //     preparedStatement.setString(1, name);
            //     preparedStatement.setInt(2, age);
            //     preparedStatement.setDouble(3, marks);

            //     preparedStatement.addBatch();

            //     System.out.print("Enter more data(y/n): ");
            //     String choice = scanner.next();

            //     if (choice.equalsIgnoreCase("N")) {
            //         break;
            //     }
            // }

            // int[] rowsAffected = preparedStatement.executeBatch();
            // for (int i = 0; i < rowsAffected.length; i++) {
            //     if (rowsAffected[i] == 0) {
            //         System.out.println("Query: " + i + " failed to execute successfully!");
            //     }
            // }

            // Transaction Handling
            // --------------------
            // connection.setAutoCommit(false);
            // String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?;";
            // String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?;";
            // PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            // PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
            // debitPreparedStatement.setDouble(1, 500);
            // debitPreparedStatement.setInt(2, 101);
            // creditPreparedStatement.setDouble(2, 500);
            // creditPreparedStatement.setInt(2, 102);
            // int rowsAffectedDebit = debitPreparedStatement.executeUpdate();
            // int rowsAffectedCredit = creditPreparedStatement.executeUpdate();

            // If successful
            // connection.commit();

            // In case of an error, use:
            // connection.rollback();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}