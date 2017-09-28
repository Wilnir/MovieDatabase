/*
Class I use to get movie title to the list model.
Im using this instead of overriding the toString() method.
https://stackoverflow.com/questions/15192174/display-jlist-elements-from-model
http://docs.oracle.com/javase/tutorial/uiswing/components/list.html#renderer
 */

package com.company;

import javax.swing.*;
import java.awt.*;

public class MovieCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Movie) {
            setText(((Movie)value).getTitle());
        }
        return this;
    }

}
