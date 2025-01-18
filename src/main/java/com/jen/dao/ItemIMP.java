package com.jen.dao;
import com.jen.models.item;
import com.jen.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ItemIMP implements ItemDAO {

    @Override
    public List<item> getAllItems() {
        List<item> itemList = new ArrayList<>();
        String sql = "SELECT * FROM Item";

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                item item = new item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getBigDecimal("price"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    @Override
    public boolean addItem(item item) {
        String sql = "INSERT INTO Item (name, price) VALUES (?, ?)";
        int rowsInserted = 0;

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setBigDecimal(2, item.getPrice());
            rowsInserted = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsInserted == 1;
    }

    @Override
    public boolean removeItemById(int id) {
        String sql = "DELETE FROM Item WHERE id = ?";
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
    public boolean updateItem(item i) {
        String sql = "UPDATE Item SET name = ?, price = ? WHERE id = ?";
        int rowsUpdated = 0;

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, i.getName());
            pstmt.setBigDecimal(2, i.getPrice());
            pstmt.setInt(3, i.getId());
            rowsUpdated = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsUpdated == 1;
    }
}

