import java.sql.*;
import java.util.Scanner;

public class unlimitedQuery {

    private static final String url="jdbc:mysql://127.0.0.1:3306/startersql";
    private static final String username="root";
    private static final String password="Imroj2850@";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection
            Connection connection=DriverManager.getConnection(url,username,password);
            System.out.println("connection establisted successfully");

            String query="INSERT INTO users(name,salary,gender) VALUES(?,?,?) ";
            PreparedStatement preparedStatement= connection.prepareStatement(query);

            Scanner scanner=new Scanner(System.in);

            while (true){
                System.out.println("enter name");
                String name= scanner.next();

                System.out.println("enter salary");
                int salary= scanner.nextInt();

                System.out.println("enter your gender");
                String gender = scanner.next();

                System.out.println("want more DATA(Y/N)");
                String choice= scanner.next();

                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,salary);
                preparedStatement.setString(3,gender);

                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int effected=preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}