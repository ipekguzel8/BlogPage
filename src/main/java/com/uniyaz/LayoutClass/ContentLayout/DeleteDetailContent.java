package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.PropertyClass.ContentCategory;
import com.vaadin.ui.*;

import java.sql.SQLException;

/**
 * Created by ipekg on 2021
 */
public class DeleteDetailContent extends VerticalLayout {
    public DeleteDetailContent(ContentCategory contentCategory) {
        Label lblId= new Label("ID");
        TextField fieldId= new TextField();
        fieldId.setValue(String.valueOf(contentCategory.getId()));
        Label lblContent=new Label("İÇERİK");
        TextField fieldContent=new TextField();
        fieldContent.setValue(contentCategory.getContent());
        Button sil=new Button("SİL");
        sil.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                DatabaseService databaseService= new DatabaseService();
                try {
                    databaseService.deleteContent(contentCategory);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        addComponent(lblId);
        addComponent(fieldId);
        addComponent(lblContent);
        addComponent(fieldContent);
        addComponent(sil);


    }
}
