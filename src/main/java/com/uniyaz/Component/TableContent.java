package com.uniyaz.Component;

import com.uniyaz.Database.DatabaseService;
import com.uniyaz.LayoutClass.BodyLayout.SideBar;
import com.uniyaz.LayoutClass.ContentLayout.DeleteDetailContent;
import com.uniyaz.PropertyClass.ContentCategory;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.uniyaz.PropertyClass.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class TableContent extends Table {
    private Container container;
    DeleteDetailContent deleteDetailContent;
    public TableContent(Category category,String islem) throws SQLException, ClassNotFoundException {
        buildContainer();
        setContainerDataSource(container);
        setColumnHeaders("ID","İÇERİK","");
        DatabaseService databaseService=new DatabaseService();
        List<ContentCategory> contentCategories = databaseService.listContentCategory(category);
        for(ContentCategory contentCategory: contentCategories){
            Item item = container.addItem(contentCategory);
            item.getItemProperty("id").setValue(contentCategory.getId());
            item.getItemProperty("icerik").setValue(contentCategory.getContent());
            Button sil=new Button("Sil");
            sil.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    MyUI current = (MyUI) UI.getCurrent();
                    current.getBody().removeAllComponents();
                    current.getBody().addComponent(deleteDetailContent = new DeleteDetailContent(contentCategory));
                    current.getBody().getSideBar().Refresh();

                }
            });
            item.getItemProperty("Sil").setValue(sil);

        }

    }

    private void buildContainer() {
        container=new IndexedContainer();
        container.addContainerProperty("id",Integer.class,null);
        container.addContainerProperty("icerik",String.class,null);
        container.addContainerProperty("Sil",Button.class,null );
        setContainerDataSource(container);
    }
}
