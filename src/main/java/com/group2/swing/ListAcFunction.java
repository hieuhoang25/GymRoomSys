/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group2.swing;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author HieuHoang
 */
public class ListAcFunction<E extends Object> extends JList<E> {
    private int selected =-1;
    private int overIndex = -1;
    private DefaultListModel dlm;
    private EventSelected event;
    public void addEventSelectedMenuItem(EventSelected event){
        this.event = event;
    }
    public ListAcFunction() {
        dlm = new DefaultListModel();
        setModel(dlm);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)){
                    int index = locationToIndex(e.getPoint());
                    Object o = dlm.getElementAt(index);
                    if (o instanceof  ModelAcFunction){
                        ModelAcFunction model = (ModelAcFunction) o;
                        if (model.getType()==ModelAcFunction.MenuItemType.MENUITEM){
                            selected = index;
                            if (event!=null){
                                event.selected(index);
                            }
                        }
                    }
                }
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                overIndex = -1;
                repaint();
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
            }
            
            
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               int index = locationToIndex(e.getPoint());
               if (index!=overIndex){
                   Object o =dlm.getElementAt(index);
                   if (o instanceof ModelAcFunction){
                       ModelAcFunction model = (ModelAcFunction) o;
                       if (model.getType()==ModelAcFunction.MenuItemType.MENUITEM){
                           overIndex = index;
                       }
                else{
                           overIndex = -1;
                       }
                       repaint();
                   }
                   
               }
            }
            
        });
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                 ModelAcFunction model;
                 if (value instanceof ModelAcFunction){
                     model = (ModelAcFunction) value;
                 }
                 else{
                     model = new ModelAcFunction("", "", ModelAcFunction.MenuItemType.EMPTY);
                     
                 }
                 AcFunctionPanel mi = new AcFunctionPanel(model);
                 mi.setSelected(selected == index);
                 mi.setOver(overIndex == index);
                 return mi;
            }

        };
                
    }
    public void addItem(ModelAcFunction model){
        dlm.addElement(model);
    }

}

