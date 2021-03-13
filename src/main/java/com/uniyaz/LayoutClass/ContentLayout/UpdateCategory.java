package com.uniyaz.LayoutClass.ContentLayout;
import com.uniyaz.Component.ComboboxCategory;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Property;
import com.vaadin.ui.*;
import java.sql.SQLException;

public class UpdateCategory extends VerticalLayout {
    TextField fieldName= new TextField();
    Button btnupdate= new Button("GÜNCELLE");
    public UpdateCategory() throws SQLException, ClassNotFoundException {
        final TextField[] fieldcategory = new TextField[1];
        ComboboxCategory category=new ComboboxCategory();
        category.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                fieldName.setValue(String.valueOf((Category)valueChangeEvent.getProperty().getValue()));
                addComponent(fieldName);
                addComponent(btnupdate);
            }
        });
        btnupdate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                DatabaseService databaseService=new DatabaseService();
                try {
                    Category value = (Category) category.getValue();
                    databaseService.updateCategory(new Category(value.getId(),fieldName.getValue()));
                    MyUI myUI = (MyUI) UI.getCurrent();
                    myUI.getBody().getSideBar().Refresh();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        addComponent(category);


    }
}
