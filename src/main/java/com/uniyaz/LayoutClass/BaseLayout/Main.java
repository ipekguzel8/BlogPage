package com.uniyaz.LayoutClass.BaseLayout;

import com.uniyaz.LayoutClass.BodyLayout.Content;
import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;

public class Main extends VerticalLayout {
    public Main() throws SQLException, ClassNotFoundException {
        MyUI myUI = (MyUI) UI.getCurrent();
        setSizeFull();
        Header header=new Header();
        Body body=myUI.getBody();
        Footer footer=new Footer();
        addComponent(header);
        addComponent(body);
        addComponent(footer);
        setExpandRatio(header,1f);
        setExpandRatio(body,8f);
        setExpandRatio(footer,1f);
    }
}
