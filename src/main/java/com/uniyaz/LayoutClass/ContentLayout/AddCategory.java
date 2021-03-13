package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Component.SideBarButton;
import com.uniyaz.Database.DatabaseService;
import com.uniyaz.LayoutClass.BodyLayout.Content;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.*;

import java.sql.SQLException;

public class AddCategory extends VerticalLayout {
    public AddCategory() {
        Label lblAdi= new Label("Kategori Adı");

        TextField fieldAdi= new TextField();
        addComponent(lblAdi);
        addComponent(fieldAdi);
        Button btnEkle=new Button("EKLE");
        btnEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Button button;
                DatabaseService databaseService= new DatabaseService();
                try {
                    databaseService.addCategory(fieldAdi.getValue());
                    MyUI myUI = (MyUI) UI.getCurrent();
                    myUI.getBody().getSideBar().addComponent(new SideBarButton(
                            fieldAdi.getValue()
                    ));

                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        addComponent(btnEkle);


    }
}
