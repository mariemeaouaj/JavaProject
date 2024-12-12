package controller;

import model.*;
import view.*;
import model.Employe.Role;
import model.Employe.Poste;

import javax.swing.*;
import java.awt.event.*;

public class EmployeController {
    private EmployeView view;
    private EmployeModel model;

    public EmployeController(EmployeView view, EmployeModel model) {
        this.view = view;
        this.model = model;

        // Add action listener to button
        this.view.btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) view.idSpinner.getValue();
                String nom = view.text1.getText();
                String prenom = view.text2.getText();
                String telephone = view.text3.getText();
                String email = view.text4.getText();
                double salaire = Double.parseDouble(view.text5.getText());

                // Retrieve Role and Poste from JComboBoxes
                Role role = (Role) view.roles.getSelectedItem();
                Poste poste = (Poste) view.postes.getSelectedItem();

                // Add employee to the model
                model.addEmployee(id, nom, prenom, email, telephone, salaire, role, poste);

                // Add the employee to the table
                Object[] row = {id, nom, prenom, telephone, email, salaire, role, poste};
                System.out.println(id + nom + prenom + telephone + email + salaire + role + poste);
                view.model.addRow(row);
            }
        });
        this.view.btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) view.model.getValueAt(selectedRow, 0);
                    model.deleteEmployee(id);
                    view.model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(view, "Please select a row to delete.");
                }
            }
        });
        
        //modifer-------------------------
        
        this.view.btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.table.getSelectedRow();
                if (selectedRow != -1) { 
                	int id = (int) view.idSpinner.getValue();
                    String nom = view.text1.getText();
                    String prenom = view.text2.getText();
                    String telephone = view.text3.getText();
                    String email = view.text4.getText();
                    double salaire = 0;
                    
                    
                    try {
                        salaire = Double.parseDouble(view.text5.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(view, "Invalid salary input. Setting default value.");

                    }
                    
                    Role role = (Role) view.roles.getSelectedItem();
                    Poste poste = (Poste) view.postes.getSelectedItem();
                    model.modifyEmployee(id,nom, prenom, email, telephone, salaire, role, poste);
                    view.model.setValueAt(id,selectedRow,0);
                    view.model.setValueAt(nom, selectedRow, 1);
                    view.model.setValueAt(prenom, selectedRow, 2);
                    view.model.setValueAt(telephone, selectedRow, 3);
                    view.model.setValueAt(email, selectedRow, 4);
                    view.model.setValueAt(salaire, selectedRow, 5);
                    view.model.setValueAt(role, selectedRow, 6);
                    view.model.setValueAt(poste, selectedRow, 7);
                } else {
                    JOptionPane.showMessageDialog(view, "Please select a row to modify.");
                }
            }
        });
    }
    
}
