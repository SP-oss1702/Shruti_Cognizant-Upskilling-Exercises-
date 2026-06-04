package Ex_32;

import java.sql.*;

public class StudentDAO {

    private Connection con;

    public StudentDAO(Connection con) {
        this.con = con;
    }

    // Insert Student
    public void insertStudent(int id, String name, int age) throws Exception {

        String sql = "INSERT INTO students VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);

        ps.executeUpdate();

        System.out.println("Student inserted successfully");
    }

    // Update Student
    public void updateStudent(int id, String name) throws Exception {

        String sql = "UPDATE students SET name=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, id);

        ps.executeUpdate();

        System.out.println("Student updated successfully");
    }
}