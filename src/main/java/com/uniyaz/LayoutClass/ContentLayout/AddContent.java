package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Component.ComboboxCategory;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.PropertyClass.ContentCategory;
import com.vaadin.data.Property;
import com.vaadin.ui.*;

import java.sql.SQLException;
import java.util.List;

public class AddContent extends VerticalLayout {
    public AddContent() throws SQLException, ClassNotFoundException {
        Category categorys;
        ComboBox cboxcategory= new ComboBox();
        DatabaseService databaseService=new DatabaseService();
        List<Category> categories = databaseService.listCategory();
        for(Category category:categories){
            cboxcategory.addItem(category);
        }
        cboxcategory.setCaption("Kategori");
        cboxcategory.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Label lblcontent= new Label("İçerik");
                TextField fieldcontent= new TextField();
                Button btnEkle= new Button("EKLE");
                btnEkle.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        DatabaseService databaseService=new DatabaseService();
                        try {
                            databaseService.addContent(new ContentCategory(fieldcontent.getValue(),(Category) cboxcategory.getValue()));
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
                addComponent(lblcontent);
                addComponent(fieldcontent);
                addComponent(btnEkle);
            }
        });
        addComponent(cboxcategory);
    }
}
