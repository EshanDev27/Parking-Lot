package org.example;

import java.sql.*;
import java.util.Collection;
import java.util.Scanner;

public class operation {

    Scanner sc = new Scanner(System.in);
    public static String URL = "jdbc:mysql://localhost:3306/parking";
    public static String username = "root";
    public static String password = "admin";
    public static Connection connection;
    public static PreparedStatement preparedStatement;
    public static Statement statement;

    static {
    try {
        connection = DriverManager.getConnection(URL, username, password);
    }catch(Exception e){
        e.printStackTrace();
        }
    }

    public void enter(String owner_name, String l_no) throws SQLException {
        String query = "SELECT COUNT(*) as count FROM lot";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if(resultSet.getInt("count") == 10){
                System.out.println("Sorry the is not vacant space in the Parking Lot");
                return;
            }
        }

        try{
        String query1 = "INSERT INTO lot(owner_name, l_no) values(?, ?);";
        preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, owner_name);
        preparedStatement.setString(2, l_no);
        preparedStatement.executeUpdate();
        System.out.println("You have successfully Parked into our Parking Lot");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("This car already exists");
        }
    }

    public void exit() throws SQLException{
        String query = "SELECT COUNT(*) as count FROM lot";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if(resultSet.getInt("count") == 0){
                System.out.println("\n...Parking lot is already vacant...\n");
                return;
            }
        }

        System.out.println("Please enter your License Number");
        String l_no = sc.nextLine();
        String query1 = "DELETE FROM lot WHERE l_no = ?";
        preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, l_no);
        preparedStatement.executeUpdate();

        System.out.println("You have successfully Exited the Parking Lot....\nPlease visit again");
    }
}
