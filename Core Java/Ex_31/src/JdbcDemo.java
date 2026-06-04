package Ex_31.src;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Root@123";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("age"));
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}