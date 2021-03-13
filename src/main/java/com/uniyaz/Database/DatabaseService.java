package com.uniyaz.Database;

import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Database.*;
import com.uniyaz.PropertyClass.ContentCategory;

import java.sql.SQLException;
import java.util.List;

public class DatabaseService {
    DatabaseDao databaseDao= new DatabaseDao();
    public void addCategory(String categoryAdi) throws SQLException, ClassNotFoundException {
        databaseDao.addCategory(categoryAdi);
    }
    public List<Category> listCategory() throws SQLException, ClassNotFoundException {
        return databaseDao.listCategory();
    }
    public void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        databaseDao.deleteCategory(category);
    }
    public List<ContentCategory> listContentCategory(Category category) throws SQLException, ClassNotFoundException {
        return databaseDao.listContentCategory(category);
    }
    public void addContent(ContentCategory contentCategory) throws SQLException, ClassNotFoundException {
        databaseDao.addContent(contentCategory);
    }
    public  void updateCategory(Category category) throws SQLException, ClassNotFoundException {
        databaseDao.updateCategory(category);
    }
    public void deleteContent(ContentCategory contentCategory) throws SQLException, ClassNotFoundException {
        databaseDao.deleteContent(contentCategory);
    }
}
