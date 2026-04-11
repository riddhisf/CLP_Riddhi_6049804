package com.demos.jdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataLayer {

    Connection conn;

    // Constructor
    public DataLayer() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Capgemini",
                "postgres",
                "Superset@26");
    }

    public boolean createTable() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(
            "CREATE TABLE employee (" +
            "id INT PRIMARY KEY, " +
            "name VARCHAR(50), " +
            "salary INT, " +
            "department VARCHAR(50), " +
            "phoneno VARCHAR(15))");
        pstmt.executeUpdate();
        pstmt.close();
        return true;
    }

    public List<Employee> getEmployee() throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");
        ResultSet rs = pstmt.executeQuery();
        List<Employee> list = convertResultSet(rs);
        pstmt.close();
        return list;
    }

    public List<Employee> insertEmployee(Employee emp) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO employee VALUES (?, ?, ?, ?, ?)");
        pstmt.setInt(1, emp.getId());
        pstmt.setString(2, emp.getName());
        pstmt.setInt(3, emp.getSalary());
        pstmt.setString(4, emp.getDepartment());
        pstmt.setString(5, emp.getPhoneno());
        int rows = pstmt.executeUpdate();
        pstmt.close();
        if (rows > 0) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM employee WHERE id=" + emp.getId());
            List<Employee> list = convertResultSet(rs);
            stmt.close();
            return list;
        }
        return null;
    }

    public List<Employee> updateSalary(int id, int newSal) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE employee SET salary=? WHERE id=?");
        pstmt.setInt(1, newSal);
        pstmt.setInt(2, id);
        int rows = pstmt.executeUpdate();
        pstmt.close();
        if (rows > 0) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM employee WHERE id=" + id);
            List<Employee> list = convertResultSet(rs);
            stmt.close();
            return list;
        }
        return null;
    }

    public List<Employee> deleteEmployee(int id) throws SQLException {
        PreparedStatement pstmt1 = conn.prepareStatement(
                "SELECT * FROM employee WHERE name=?");
        pstmt1.setInt(1, id);
        ResultSet rs = pstmt1.executeQuery();
        List<Employee> list = convertResultSet(rs);
        PreparedStatement pstmt2 = conn.prepareStatement(
                "DELETE FROM employee WHERE name=?");
        pstmt2.setInt(1, id);
        int rows = pstmt2.executeUpdate();
        pstmt1.close();
        pstmt2.close();
        if (rows > 0)
            return list;
        else
            return null;
    }

    public List<Employee> getEmployeeById(int id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM employee WHERE id=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        List<Employee> list = convertResultSet(rs);
        pstmt.close();
        return list;
    }

    public void closeConn() throws SQLException {
        conn.close();
    }

    // Helper Methods
    public List<Employee> convertResultSet(ResultSet rs) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getInt("salary"));
            emp.setDepartment(rs.getString("department"));
            emp.setPhoneno(rs.getString("phoneno"));
            employees.add(emp);
        }
        return employees;
    }
    
    public boolean idExists(int id) throws SQLException {
        PreparedStatement pstmt =
                conn.prepareStatement("SELECT * FROM employee WHERE id=?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        boolean exists = rs.next();
        pstmt.close();
        return exists;
    }
}