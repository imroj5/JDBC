import java.sql.*;
import java.util.Scanner;

public class pracJDBC {

    private static final String url="jdbc:mysql://127.0.0.1:3306/startersql";
    private static final String username="root";
    private static final String password="Imroj2850@";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection
            Connection connection=DriverManager.getConnection(url,username,password);
            System.out.println("connection establisted successfully");

            //query
            String query="INSERT INTO address(user_id,city,pincode) VALUES(?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(query);

            preparedStatement.setInt(1,21);
            preparedStatement.setString(2,"ranhi");
            preparedStatement.setInt(3,807512);

            int changes=preparedStatement.executeUpdate();

            connection.close();

            if(changes>0){
                System.out.println("inserted succesfully");
            }else {
                System.out.println("failed you losser");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
