import java.sql.*;

public class TransferMoney {

    public static void transfer(Connection con,
                                int fromAccount,
                                int toAccount,
                                double amount) {

        try {

            con.setAutoCommit(false);

            // Debit amount
            PreparedStatement debit = con.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");

            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);

            int debitRows = debit.executeUpdate();

            // Credit amount
            PreparedStatement credit = con.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?");

            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);

            int creditRows = credit.executeUpdate();

            if (debitRows > 0 && creditRows > 0) {

                con.commit();
                System.out.println("Transaction Successful");

            } else {

                con.rollback();
                System.out.println("Transaction Failed");
            }

        } catch (Exception e) {

            try {
                con.rollback();
                System.out.println("Transaction Rolled Back");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Root@123";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            transfer(con, 1, 2, 1000);

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}