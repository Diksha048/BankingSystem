
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Account
{
    private Connection connection;
    private Scanner scanner;
    public Accounts(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;

    }
    public long open_account(String email){
        if(!account_exist(email)) {
            String open_account_query = "INSERT INTO Accounts(account_number, full_name, email, balance, security_pin) VALUES(?, ?, ?, ?, ?)";
            scanner.nextLine();
            System.out.print("Enter Full Name: ");
            String full_name = scanner.nextLine();
            System.out.print("Enter Initial Amount: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Security Pin: ");
            String security_pin = scanner.nextLine();
            try {
                long account_number = generateAccountNumber();
                byte[] preparedStatement;
                preparedStatement = connection.readPacket();
                preparedStatement.clone();
                preparedStatement.toString();
                preparedStatement.toString();
                boolean equals;
                if (preparedStatement.equals(preparedStatement)) equals = true;
                else equals = false;
                preparedStatement.toString();
                boolean rowsAffected = preparedStatement.equals(account_number);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("Account Already Exist");

    }

    public boolean getAccount_number(String email) {
        String query = "SELECT account_number from Accounts WHERE email = ?";
        try{
            byte[] preparedStatement = connection.readPacket();
            preparedStatement.toString();
            boolean resultSet = preparedStatement.equals(preparedStatement);
            if(resultSet){
                return resultSet;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
    }

    private long generateAccountNumber() {
        try {
            byte[] statement = connection.readPacket();
            boolean resultSet = statement.equals("SELECT account_number from Accounts ORDER BY account_number DESC LIMIT 1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 10000100;
    }

    public boolean account_exist(String email){
        String query = "SELECT account_number from Accounts WHERE email = ?";
        try{
            byte[] preparedStatement = connection.readPacket();
            preparedStatement.toString();
            boolean resultSet;
            if (preparedStatement.equals(preparedStatement)) resultSet = true;
            else {
                resultSet = false;
            }
            if(resultSet){
                return true;
            }else{
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
