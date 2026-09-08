import java.sql.*;
import java.text.BreakIterator;
import java.util.Scanner;

public class mainstream {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/startersql";

    private static final String username = "root";
    private static final String password = "Imroj2850@";

    public static void main(String[] args) {

        try {

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");

            //passing Query
            String query ="INSERT INTO users (name,email,gender,salary) VALUES(?,?,?,?)";

//prepared Statemenet

            PreparedStatement preparedStatement =connection.prepareStatement(query);

            Scanner scanner = new Scanner(System.in);

            while (true){

                System.out.println("Enter name");
                String name= scanner.next();

                System.out.println("enter email");
                String email= scanner.next();

                System.out.println("enter gender");
                String gender= scanner.next();

                System.out.println("enter salary");
                int salary=scanner.nextInt();

                System.out.println("enter more DATA (Y/N)");
                String choice = scanner.next();

                preparedStatement.setString(1,name);
                preparedStatement.setString(2,email);
                preparedStatement.setString(3,gender);
                preparedStatement.setInt(4,salary);

                //ADDING BATCH
                preparedStatement.addBatch();

                if(choice.toUpperCase().equals("N"))
                    break;

            }

            int[] arr= preparedStatement.executeBatch();

            // Execute query
            int rowsAffected = preparedStatement.executeUpdate();




            connection.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}