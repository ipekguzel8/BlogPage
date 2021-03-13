package com.uniyaz.Component;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.vaadin.ui.ComboBox;
import java.sql.SQLException;
import java.util.List;

public class ComboboxCategory extends ComboBox {
    public ComboboxCategory() throws SQLException, ClassNotFoundException {
        DatabaseService databaseService=new DatabaseService();
        List<Category> categories = databaseService.listCategory();
        for(Category category:categories){
            addItem(category);
        }
        setCaption("Kategori");
    }
}
