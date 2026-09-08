import java.sql.*;
import java.text.BreakIterator;
import java.util.Scanner;

public class Main {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/lender";

    private static final String username = "root";
    private static final String password = "Imroj2850@";

    public static void main(String[] args) {

        try {

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
            connection.setAutoCommit(false);

       String debit_query="UPDATE accounts SET balance = balance-? WHERE accountNO=? ";
       String credit_query="UPDATE accounts SET balance = balance +? WHERE accountNO = ?";

       PreparedStatement debitpreparedStatement = connection.prepareStatement(debit_query);
       PreparedStatement creditpreparedStatement = connection.prepareStatement(credit_query);

       Scanner scanner = new Scanner(System.in);
            System.out.println("enter amount=");
          double amount= scanner.nextDouble();

debitpreparedStatement.setDouble(1,amount);
debitpreparedStatement.setInt(2,101);

creditpreparedStatement.setDouble(1,amount);
creditpreparedStatement.setInt(2,102);

            int rowsAffected1 = debitpreparedStatement.executeUpdate();
int rowsAffected2 = creditpreparedStatement.executeUpdate();




            connection.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}