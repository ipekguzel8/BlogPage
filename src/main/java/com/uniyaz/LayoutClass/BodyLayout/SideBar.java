package com.uniyaz.LayoutClass.BodyLayout;

import com.uniyaz.Component.SideBarButton;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;
import java.util.List;

public class SideBar extends VerticalLayout {
    public SideBar() throws SQLException, ClassNotFoundException {
        setSizeFull();
        SideBarCompanent();
    }
    public void SideBarCompanent(){
        Button button;
        DatabaseService databaseService= new DatabaseService();
        try {
            List<Category> categories = databaseService.listCategory();
            System.out.println(categories);

            for (Category categori:categories){
                MyUI current = (MyUI) UI.getCurrent();
                addComponent(new SideBarButton(categori.getName()));
            }
        }catch (Exception e){
            System.out.println("Kategori yok");
        }
    }
    public void Refresh(){
        removeAllComponents();
        SideBarCompanent();
    }
}
