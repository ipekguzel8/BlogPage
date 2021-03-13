package com.uniyaz.Ui;

import javax.servlet.annotation.WebServlet;

import com.uniyaz.LayoutClass.BaseLayout.Body;
import com.uniyaz.LayoutClass.BaseLayout.Main;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {
private Body body=new Body();

    public Body getBody() {
        return body;
    }

    public MyUI() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Main main= null;
        try {
            main = new Main();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        setContent(main);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
