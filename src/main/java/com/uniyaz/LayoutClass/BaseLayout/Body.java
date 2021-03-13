package com.uniyaz.LayoutClass.BaseLayout;

import com.uniyaz.LayoutClass.BodyLayout.Content;
import com.uniyaz.LayoutClass.BodyLayout.SideBar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import java.sql.SQLException;

public class Body extends HorizontalLayout {
private SideBar sideBar= new SideBar();
private Content content= new Content();

    public SideBar getSideBar() {
        return sideBar;
    }

    public Content getContent() {
        return content;
    }

    public Body() throws SQLException, ClassNotFoundException {
        setSizeFull();
        addComponent(sideBar);
        addComponent(content);
        setExpandRatio(sideBar,2f);
        setExpandRatio(content,8f);
    }
}
