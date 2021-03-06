package View;


import controller.database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class create the form SearhPage for passenger information.
 * @author yunfu
 * @version 1.0
 * @since 17/11/2014
 */
public class SearchPage extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    /**
     * Creates new form SearchPage
     */
    public SearchPage() {
       
        initComponents();
        this.setVisible(true);
    }
    
    public static database db = new database();
    
    //passenger Passenger = new passenger();
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Fu Yun
    private void initComponents() {
        jMenuBar1 = new JMenuBar();
        Query = new JMenu();
        Passengers = new JMenuItem();
        Cruises = new JMenuItem();
        passengerSort = new JComboBox();
        jLabel1 = new JLabel();
        PassengerSearch = new JButton();
        jScrollPane1 = new JScrollPane();
        PassengerTable = new JTable();
        ShowAllPassengers = new JButton();
        jPopupMenu1 = new JPopupMenu();
        jMenuItem1 = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());

        //======== jMenuBar1 ========
        {

            //======== Query ========
            {
                Query.setText("Query");

                //---- Passengers ----
                Passengers.setText("Passengers");
                Passengers.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PassengersActionPerformed(e);
                    }
                });
                Query.add(Passengers);

                //---- Cruises ----
                Cruises.setText("Cruises");
                Cruises.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CruisesActionPerformed(e);
                    }
                });
                Query.add(Cruises);
            }
            jMenuBar1.add(Query);
        }
        setJMenuBar(jMenuBar1);

        //---- passengerSort ----
        passengerSort.setModel(new DefaultComboBoxModel(new String[] {
            "Nationality",
            "AgeRange"
        }));
        passengerSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passengerSortActionPerformed(e);
            }
        });
        contentPane.add(passengerSort, new GridBagConstraints(1, 0, 1, 2, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(20, 4, 0, 0), 29, 0));

        //---- jLabel1 ----
        jLabel1.setText("Find passengers by");
        contentPane.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(20, 20, 0, 0), 25, 4));

        //---- PassengerSearch ----
        PassengerSearch.setText("Search");
        PassengerSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassengerSearchActionPerformed(e);
            }
        });
        contentPane.add(PassengerSearch, new GridBagConstraints(2, 0, 1, 3, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(20, 26, 0, 0), 0, 0));

        //======== jScrollPane1 ========
        {
            jScrollPane1.setViewportView(PassengerTable);
        }
        contentPane.add(jScrollPane1, new GridBagConstraints(0, 3, 5, 1, 1.0, 1.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(11, 10, 27, 6), 744, 194));

        //---- ShowAllPassengers ----
        ShowAllPassengers.setText("Show All passengers");
        ShowAllPassengers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAllPassengersActionPerformed(e);
            }
        });
        contentPane.add(ShowAllPassengers, new GridBagConstraints(3, 0, 1, 3, 0.0, 0.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(20, 25, 0, 0), 7, 0));
        pack();
        setLocationRelativeTo(getOwner());

        //---- jMenuItem1 ----
        jMenuItem1.setText("jMenuItem1");
    }// </editor-fold>//GEN-END:initComponents

    private void PassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassengersActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PassengersActionPerformed

    private void PassengerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassengerSearchActionPerformed
        // TODO add your handling code here:
        String[] name = {"Nationality","AgeRange","Money","Number of Passengers"};
        String[][] data = new String[300][4];//此处略去赋值操作
        DefaultTableModel defaultmodel = new DefaultTableModel(data, name);
        PassengerTable.setModel(defaultmodel);
        
        if(passengerSort.getSelectedItem().equals((Object)"Nationality")){
            
        for(int i=0; i<PassengerTable.getRowCount(); i++){
                    PassengerTable.setValueAt(null, i, 0);
                    PassengerTable.setValueAt(null, i, 1);
                    PassengerTable.setValueAt(null, i, 2);
                    PassengerTable.setValueAt(null, i, 3);
                }
            try {
                for(int i=0; i<db.getPassenger().size(); i++){
                    PassengerTable.setValueAt(db.getPassenger().get(i).getNationality(), i, 0);
                    PassengerTable.setValueAt(db.getPassenger().get(i).getAgeRange(), i, 1);
                    PassengerTable.setValueAt(db.getPassenger().get(i).getMoney(), i, 2);
                    PassengerTable.setValueAt(db.getPassenger().get(i).getNoOfPassenger(), i, 3);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(passengerSort.getSelectedItem().equals((Object)"AgeRange")){
           for(int i=0; i<PassengerTable.getRowCount(); i++){
                    PassengerTable.setValueAt(null, i, 0);
                    PassengerTable.setValueAt(null, i, 1);
                    PassengerTable.setValueAt(null, i, 2);
                    PassengerTable.setValueAt(null, i, 3);
                }
            try {
               for(int i=0; i<db.getPassenger().size(); i++){
                    PassengerTable.setValueAt(db.getPassenger2().get(i).getNationality(), i, 0);
                    PassengerTable.setValueAt(db.getPassenger2().get(i).getAgeRange(), i, 1);
                    PassengerTable.setValueAt(db.getPassenger2().get(i).getMoney(), i, 2);
                    PassengerTable.setValueAt(db.getPassenger2().get(i).getNoOfPassenger(), i, 3);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_PassengerSearchActionPerformed

    private void ShowAllPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowAllPassengersActionPerformed
        // TODO add your handling code here:

        
        String[] name = {"Passenger ID","Name","Nationality","Age", "Age Range"};
        String[][] data = new String[300][5];//此处略去赋值操作
        DefaultTableModel defaultmodel = new DefaultTableModel(data, name);
        PassengerTable.setModel(defaultmodel);
         try {
               for(int i=0; i<db.getPassengerAll().size(); i++){
                    PassengerTable.setValueAt(db.getPassengerAll().get(i).getID(), i, 0);
                    PassengerTable.setValueAt(db.getPassengerAll().get(i).getName(), i, 1);
                    PassengerTable.setValueAt(db.getPassengerAll().get(i).getNationality(), i, 2);
                    PassengerTable.setValueAt(db.getPassengerAll().get(i).getAge(), i, 3);
                    PassengerTable.setValueAt(db.getPassengerAll().get(i).getAgeRange(), i, 4);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_ShowAllPassengersActionPerformed

    private void CruisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CruisesActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        Cruises cruise = new Cruises();
//        cruise.setVisible(true);
        
        
        
    }//GEN-LAST:event_CruisesActionPerformed

    private void passengerSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengerSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passengerSortActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Fu Yun
    private JMenuBar jMenuBar1;
    private JMenu Query;
    private JMenuItem Passengers;
    private JMenuItem Cruises;
    private JComboBox passengerSort;
    private JLabel jLabel1;
    private JButton PassengerSearch;
    private JScrollPane jScrollPane1;
    private JTable PassengerTable;
    private JButton ShowAllPassengers;
    private JPopupMenu jPopupMenu1;
    private JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
