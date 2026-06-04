package Ex_32;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Root@123";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url, user, password);

            StudentDAO dao = new StudentDAO(con);

            // Insert
            dao.insertStudent(3, "Anu", 22);

            // Update
            dao.updateStudent(3, "Ananya");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}