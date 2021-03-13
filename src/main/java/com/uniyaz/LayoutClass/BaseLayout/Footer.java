package com.uniyaz.LayoutClass.BaseLayout;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class Footer extends HorizontalLayout {
    public Footer() {
        setSizeFull();
        Label label=new Label();
        label.setContentMode(ContentMode.HTML);
        label.setValue(FontAwesome.COPYRIGHT.getHtml()+"Copyright");
        label.setWidthUndefined();
        addComponent(label);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
    }
}
