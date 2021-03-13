package com.uniyaz.LayoutClass.BaseLayout;
import com.uniyaz.LayoutClass.BodyLayout.Content;
import com.uniyaz.LayoutClass.ContentLayout.*;
import com.uniyaz.PropertyClass.Category;
import com.uniyaz.Ui.MyUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

import java.sql.SQLException;

public class Header extends HorizontalLayout {
    MenuBar menuBar;
    AddCategory addCategory= new AddCategory();
    DeleteCategory deleteCategory=new DeleteCategory();
    AddContent addContent =new AddContent();
    UpdateCategory updateCategory= new UpdateCategory();
    DeleteContent deleteContent= new DeleteContent();
    UpdateContentCategory updateContent= new UpdateContentCategory();
    public Header() throws SQLException, ClassNotFoundException {
        setSizeFull();
        menuBar = getMenuBar();
        menuBar.setWidthUndefined();
        addComponent(menuBar);
        setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);
    }

    private MenuBar getMenuBar() {
        menuBar = new MenuBar();
        MenuBar.MenuItem ekle = menuBar.addItem("EKLE", FontAwesome.PLUS, null);
        ekle.addItem("KATEGORİ EKLE", FontAwesome.PLUS, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(addCategory);
                addCategory.setWidthUndefined();
                getContent().setComponentAlignment(addCategory,Alignment.MIDDLE_CENTER);

            }
        });
        ekle.addItem("İÇERİK EKLE", FontAwesome.PLUS, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(addContent);
            }
        });
        MenuBar.MenuItem sil = menuBar.addItem("SİL", FontAwesome.TRASH, null);
        sil.addItem("KATEGORİ SİL", FontAwesome.TRASH, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(deleteCategory);
            }
        });
        sil.addItem("İÇERİK SİL", FontAwesome.TRASH, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(deleteContent);
            }
        });
        MenuBar.MenuItem guncelle = menuBar.addItem("GÜNCELLE", FontAwesome.EDIT, null);
        guncelle.addItem("KATEGORİ GÜNCELLE", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(updateCategory);
            }
        });
        guncelle.addItem("İÇERİK GÜNCELLE", FontAwesome.EDIT, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                getContent().removeAllComponents();
                getContent().addComponent(updateContent);

            }
        });
        MenuBar.MenuItem listele = menuBar.addItem("LİSTELE", FontAwesome.DATABASE, new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                try {
                    ListCategory listCategory=new ListCategory();
                    getContent().removeAllComponents();
                    getContent().addComponent(listCategory);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        return menuBar;
    }

    private Content getContent() {
        MyUI myUI = (MyUI) UI.getCurrent();
        return myUI.getBody().getContent();
    }
}
