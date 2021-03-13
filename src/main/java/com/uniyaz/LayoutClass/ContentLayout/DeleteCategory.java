package com.uniyaz.LayoutClass.ContentLayout;
import com.uniyaz.Component.ComboboxCategory;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.sql.SQLException;

public class DeleteCategory extends VerticalLayout {
    public DeleteCategory() throws SQLException, ClassNotFoundException {
        ComboboxCategory comboboxCategory=new ComboboxCategory();
        comboboxCategory.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {

            }
        });
        Button btndelete= new Button("DELETE");
        btndelete.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                DatabaseService databaseService=new DatabaseService();
                try {
                    databaseService.deleteCategory((Category)comboboxCategory.getValue());
                    MyUI myUI = (MyUI) UI.getCurrent();
                    myUI.getBody().getSideBar().Refresh();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        addComponent(comboboxCategory);
        addComponent(btndelete);
    }
}
