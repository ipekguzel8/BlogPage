package com.uniyaz.Database;

import com.uniyaz.PropertyClass.Category;
import com.uniyaz.PropertyClass.ContentCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDao {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    List<Category> categoryList= new ArrayList<Category>();
    List<ContentCategory> contentCategoryList= new ArrayList<ContentCategory>();
    Connection connection;
    String sql;
    public void addCategory(String  categoryAdi) throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="INSERT INTO ipekblog.kategori (ADI) VALUES (?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,categoryAdi);
        preparedStatement.execute();
    }
    public void deleteCategory(Category  category) throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="DELETE FROM ipekblog.kategori WHERE ADI='"+category.getName()+"';";
        System.out.println(sql);
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.execute();
    }
    public void deleteContent(ContentCategory contentCategory) throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="DELETE FROM ipekblog.icerik WHERE ID="+contentCategory.getId()+";";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.execute();
    }
    public List<Category> listCategory() throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="SELECT * FROM ipekblog.kategori";
        Statement statement =connection.createStatement();
        resultSet =statement.executeQuery(sql);
        while (resultSet.next()){
            int id= (resultSet.getInt("ID"));
            String adi=(resultSet.getString("ADI"));
            categoryList.add(new Category(id,adi));
        }
        return categoryList;
    }
    public List<ContentCategory> listContentCategory(Category category) throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="SELECT * FROM ipekblog.icerik WHERE KATEGORIID="+category.getId()+";";
        System.out.println(sql);
        Statement statement =connection.createStatement();
        resultSet =statement.executeQuery(sql);
        while (resultSet.next()){
            int id= (resultSet.getInt("ID"));
            String adi=(resultSet.getString("ICERIK"));
            contentCategoryList.add(new ContentCategory(id,adi,category));
        }
        return contentCategoryList;
    }
    public void addContent(ContentCategory category) throws SQLException, ClassNotFoundException {
        connection=DatabaseConnection.getConnection();
        sql="INSERT INTO ipekblog.icerik (ICERIK,KATEGORIID) VALUES (?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,category.getContent());
        preparedStatement.setInt(2,category.getCategory().getId());
        preparedStatement.execute();
    }
    public  void updateCategory(Category category) throws SQLException, ClassNotFoundException {
        Connection connection3 = DatabaseConnection.getConnection();
        String sql="UPDATE ipekblog.kategori SET ADI ='"+category.getName()+"' WHERE ID="+category.getId();
        Statement stmt= null;
        try {
            stmt = connection3.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            stmt.execute(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
