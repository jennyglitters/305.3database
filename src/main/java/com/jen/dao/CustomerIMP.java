package com.jen.dao;

import com.jen.models.customer;
import com.jen.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerIMP implements CustomerDAO {

    @Override
    public customer getCustomerById(int id) {
        customer cust = null;
        String sql = "SELECT * FROM Customer WHERE id = ?";

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cust = new customer();
                cust.setId(rs.getInt("id"));
                cust.setEmail(rs.getString("email"));
                cust.setFname(rs.getString("fname"));
                cust.setLname(rs.getString("lname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cust;
    }

    @Override
    public boolean addCustomer(customer c) {
        String sql = "INSERT INTO Customer (email, fname, lname) VALUES (?, ?, ?)";
        int rowsInserted = 0;

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, c.getEmail());
            pstmt.setString(2, c.getFname());
            pstmt.setString(3, c.getLname());
            rowsInserted = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted == 1;
    }

    @Override
    public boolean removeCustomerById(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        int rowsDeleted = 0;

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rowsDeleted = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsDeleted == 1;
    }

    @Override
    public List<customer> getAllCustomers() {
        List<customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                customer c = new customer();
                c.setId(rs.getInt("id"));
                c.setEmail(rs.getString("email"));
                c.setFname(rs.getString("fname"));
                c.setLname(rs.getString("lname"));
                customers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    @Override
    public boolean updateCustomer(customer c) {
        String sql = "UPDATE Customer SET email = ?, fname = ?, lname = ? WHERE id = ?";
        int rowsUpdated = 0;

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, c.getEmail());
            pstmt.setString(2, c.getFname());
            pstmt.setString(3, c.getLname());
            pstmt.setInt(4, c.getId());

            rowsUpdated = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsUpdated == 1;
    }
    @Override
    public void saveCustomer(List<customer> customerList) {
        String sql = "INSERT INTO Customer (id, fname, email, lname) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (customer c : customerList) {
                pstmt.setInt(1, c.getId());
                pstmt.setString(2, c.getFname());
                pstmt.setString(3, c.getEmail());
                pstmt.setString(4, c.getLname());
                int affectedRows = pstmt.executeUpdate();
                System.out.println(affectedRows + " row(s) inserted for ID = " + c.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
