package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.PropertyClass.ContentCategory;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

import java.sql.SQLException;
import java.util.List;

public class DetailCategory extends HorizontalLayout {
    private Table table;
    private Container container;
    public Category category;
    public DetailCategory(Category category) throws SQLException, ClassNotFoundException {
        this.category=category;
        setSizeFull();
        buildLayout();
        fillTable();
    }

    private void buildLayout() {
        buildTable();
        addComponent(table);
    }

    private void buildTable() {

        table = new Table();
        table.setSizeFull();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ADI");
    }

    private void fillTable() throws SQLException, ClassNotFoundException {

        DatabaseService kategoriService = new DatabaseService();
        List<ContentCategory> kategoriList = kategoriService.listContentCategory(category);
        for (ContentCategory kategori : kategoriList) {
            Item item = container.addItem(kategori);
            item.getItemProperty("ID").setValue(kategori.getId());
            item.getItemProperty("ICERIK").setValue(kategori.getContent());

        }
    }

    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("ID", Integer.class, null);
        container.addContainerProperty("ICERIK", String.class, null);
    }
}
