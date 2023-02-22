/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mttprojects.program;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import static utils.ToolsClass.*;

/**
 *
 * @author matiw
 */
public class ContactsInternalFrame extends javax.swing.JInternalFrame {

    ArrayList<ContactClass> dataList = new ArrayList<ContactClass>();
    DefaultListModel model = new DefaultListModel<>();
    
    public int listIndex = -1;
    /**
     * Creates new form ContactsInternalFrame
     */
    public ContactsInternalFrame() {
        initComponents();
        dataList = new ArrayList<ContactClass>();
        contactList.setModel(model);
        contactList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 1) {
                int index = list.locationToIndex(evt.getPoint());
                    listIndex = index;
                    printLog("OneClick on index" + index);
                }
                
                else if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    listIndex = index;
                    UpdateContact();
                    printLog("doubleclick on index" + index);
                } else if (evt.getClickCount() == 3) {

                    // Triple-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    listIndex = index;
                    printLog("tripleclick on index" + index);
                }
            }
        });
    }

    public void onSave(String name) {
        model.addElement(name);
    }

    public void AddNewContact(ContactClass contact)
    {
        dataList.add(contact);
        printLog("Add contact " + contact.Name);
        UpdateUI();
        reEnable();
    }
    
    public void UpdateContact(ContactClass contact)
    {
        dataList.set(listIndex, contact);
        
        UpdateUI();
        reEnable();
    }
    
    public void UpdateUI()
    {
        model =  new DefaultListModel<>();
        
        for(int i = 0; i < dataList.size(); i++)
        {
            ContactClass contact = dataList.get(i);
            model.addElement(contact.Name + " | " + contact.Number + " | " +contact.Email + " | " +contact.Address );
        }
        contactList.setModel(model);
        contactList.updateUI();
        listIndex = -1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        MyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList<>();
        newBT = new javax.swing.JButton();
        editBT = new javax.swing.JButton();
        closeBT = new javax.swing.JButton();
        deleteBT = new javax.swing.JButton();

        setTitle("Contactos");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setRequestFocusEnabled(false);

        jDesktopPane.setOpaque(false);

        contactList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(contactList);

        newBT.setText("Nuevo");
        newBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBTActionPerformed(evt);
            }
        });

        editBT.setText("Editar");
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });

        closeBT.setText("Salir");
        closeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBTActionPerformed(evt);
            }
        });

        deleteBT.setText("Borrar");
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(MyPanel);
        MyPanel.setLayout(MyPanelLayout);
        MyPanelLayout.setHorizontalGroup(
            MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newBT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(closeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        MyPanelLayout.setVerticalGroup(
            MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeBT, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(newBT, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(editBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(390, Short.MAX_VALUE))
            .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jDesktopPane.setLayer(MyPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBTActionPerformed
        createNewContactWindow(null);
    }//GEN-LAST:event_newBTActionPerformed

    private void closeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        UpdateContact();
            
    }//GEN-LAST:event_editBTActionPerformed
    void UpdateContact()
    {
        printLog("Try to edit index " + listIndex);
        
        if(model.get(listIndex) != null)
        {
            ContactClass toEdit = dataList.get(listIndex);
            printLog("Contact Get with index "  + listIndex + " with Name: " + toEdit.Name);
            createNewContactWindow(toEdit);
        }
    }
    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        if(model.get(listIndex) != null)
        {
            dataList.remove(listIndex);
            UpdateUI();
        }
    }//GEN-LAST:event_deleteBTActionPerformed
    void reEnable() {
        contactList.setEnabled(true);
        newBT.setEnabled(true);
        deleteBT.setEnabled(true);
        editBT.setEnabled(true);
    }

    private void createNewContactWindow(ContactClass model) {
        this.setFocusable(false);
        NewContactFrame newContactWindow = new NewContactFrame();
        newContactWindow.parentFrame = this;
        newContactWindow.toUpdate = model;
        newContactWindow.SetData();
       this.add(newContactWindow);
        jDesktopPane.add(newContactWindow);
        
        newContactWindow.moveToFront();
        newContactWindow.setLocation(jDesktopPane.getWidth()/2 - newContactWindow.getWidth()/2,
        jDesktopPane.getHeight()/2 - newContactWindow.getHeight()/2);
         
        newContactWindow.setVisible(true);
        contactList.setEnabled(false);
        newBT.setEnabled(false);
        deleteBT.setEnabled(false);
        editBT.setEnabled(false);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MyPanel;
    private javax.swing.JButton closeBT;
    private javax.swing.JList<String> contactList;
    private javax.swing.JButton deleteBT;
    private javax.swing.JButton editBT;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newBT;
    // End of variables declaration//GEN-END:variables
}