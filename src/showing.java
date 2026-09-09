import java.sql.*;
//import java.util.Scanner;

public class showing {

    private static final String url="jdbc:mysql://127.0.0.1:3306/startersql";
    private static final String username="root";
    private static final String password="Imroj2850@";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection
            Connection connection=DriverManager.getConnection(url,username,password);
            System.out.println("connection establisted successfully");

            String query="SELECT * FROM users";
            PreparedStatement preparedStatement= connection.prepareStatement(query);

            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println("id="+resultSet.getInt("id"));
                System.out.println("name="+resultSet.getString("name"));
              //  System.out.println("age"+resultSet.getString("age"));
                System.out.println("salary="+resultSet.getString("salary"));
                System.out.println("_________________________________________________");

            }


        connection.close();


            } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }}

