package com.jen.dao;

import com.jen.models.item;
import java.util.List;

public interface ItemDAO {
    List<item> getAllItems();
    boolean addItem(item i);
    boolean removeItemById(int id);
    boolean updateItem(item i);
}


