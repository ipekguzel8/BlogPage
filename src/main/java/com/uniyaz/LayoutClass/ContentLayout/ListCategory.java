package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Database.DatabaseService;
import com.uniyaz.PropertyClass.Category;
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

public class ListCategory extends HorizontalLayout {
    private Table table;
    private Container container;

    public ListCategory() throws SQLException, ClassNotFoundException {

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
        table.setColumnHeaders("ID", "ADI", "");
    }

    private void fillTable() throws SQLException, ClassNotFoundException {
        DatabaseService kategoriService = new DatabaseService();
        List<Category> kategoriList = kategoriService.listCategory();
        for (Category kategori : kategoriList) {
            Item item = container.addItem(kategori);
            item.getItemProperty("id").setValue(kategori.getId());
            item.getItemProperty("adi").setValue(kategori.getName());

            Button guncelle = new Button();
            guncelle.setIcon(FontAwesome.EDIT);
            guncelle.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    try {
                        DetailCategory detailCategory = new DetailCategory(kategori);
                        MyUI myUI = (MyUI) UI.getCurrent();
                        myUI.getBody().getContent().removeAllComponents();
                        myUI.getBody().getContent().addComponent(detailCategory);
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            });
            item.getItemProperty("guncelle").setValue(guncelle);
        }
    }

    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("id", Integer.class, null);
        container.addContainerProperty("adi", String.class, null);
        container.addContainerProperty("guncelle", Button.class, null);
    }
}
