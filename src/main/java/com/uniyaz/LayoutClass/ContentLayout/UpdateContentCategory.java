package com.uniyaz.LayoutClass.ContentLayout;

import com.uniyaz.Component.ComboboxCategory;
import com.uniyaz.Component.TableContent;
import com.uniyaz.PropertyClass.Category;
import com.vaadin.data.Property;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;

/**
 * Created by ipekg on 2021
 */
public class UpdateContentCategory extends VerticalLayout {
    public UpdateContentCategory() throws SQLException, ClassNotFoundException {
        ComboboxCategory comboboxCategory=new ComboboxCategory();

        comboboxCategory.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                TableContent tableContent=null;
                try {
                    tableContent = new TableContent((Category) valueChangeEvent.getProperty().getValue(),"Güncelle");
                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                addComponent(tableContent);
            }
        });
        addComponent(comboboxCategory);
    }
}
