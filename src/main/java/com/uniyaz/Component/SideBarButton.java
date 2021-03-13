package com.uniyaz.Component;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.*;

/**
 * Created by ipekg on 2021
 */
public class SideBarButton extends Button {
    public SideBarButton(String caption){
        setCaption(caption);
        this.addStyleName(ValoTheme.BUTTON_LINK);
        this.addStyleName(ValoTheme.LINK_LARGE);
        this.setWidth(100, Sizeable.Unit.PERCENTAGE);
    }
}
