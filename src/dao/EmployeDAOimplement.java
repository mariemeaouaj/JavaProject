package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Employe;
import model.Employe.Poste;
import model.Employe.Role;

public  class EmployeDAOimplement implements EmployeDAOI {
	private static BDConnection c;
	
	
	
	public void addEmployee(Employe emp) {
		
		c = new BDConnection();
		
        String sql = "INSERT INTO `employe`(`id`, `nom`, `prenom`, `email`, `phone`, `salaire`, `role`, `poste`) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = c.getConnect().prepareStatement(sql)) {
        	st.setInt(1, emp.getId());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getPrenom());
            st.setString(4, emp.getEmail());
            st.setString(5, emp.getPhone());
            st.setDouble(6, emp.getSalaire());
            st.setString(7, emp.getRole().name());
            st.setString(8, emp.getPoste().name());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee added successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error adding employee: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	 public void deleteEmployee(int id) {
	        String sql = "DELETE FROM `employe` WHERE id = ?";
	        try (PreparedStatement st = c.getConnect().prepareStatement(sql)) {
	            st.setInt(1, id);
	            int rowsAffected = st.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Are you sure you want to delete the employee?", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Are you sure you want to delete the employee?", "Information", JOptionPane.WARNING_MESSAGE);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Error deleting employee: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	 
	 
	 @Override
	    public void modifyEmployee(Employe emp) {
	        String sql = "UPDATE `employe` SET `nom`=?,`prenom`=?,`email`=?,`phone`=?,`salaire`=?,`role`=?,`poste`=? WHERE  id = ?";
	        try (PreparedStatement st = c.getConnect().prepareStatement(sql)) {
	            st.setString(1, emp.getNom());
	            st.setString(2, emp.getPrenom());
	            st.setString(3, emp.getEmail());
	            st.setString(4, emp.getPhone());
	            st.setDouble(5, emp.getSalaire());
	            st.setString(6, emp.getRole().name());
	            st.setString(7, emp.getPoste().name());
	           
	            st.setInt(8, emp.getId());
	            int rowsAffected = st.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "Employee updated successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "No employee found to update.", "Warning", JOptionPane.WARNING_MESSAGE);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Error updating employee: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	 
	 @Override
	    public List<Employe> getAllEmployees() {
	        List<Employe> employees = new ArrayList<>();
	        String sql = "SELECT * FROM Employees";
	        try (PreparedStatement st = c.getConnect().prepareStatement(sql);
	             ResultSet rs = st.executeQuery()) {
	            while (rs.next()) {
	                employees.add(new Employe(
	                		rs.getInt("id"),
	                        rs.getString("nom"),
	                        rs.getString("prenom"),
	                        rs.getString("email"),
	                        rs.getString("telephone"),
	                        rs.getDouble("salaire"),
	                        Role.valueOf(rs.getString("role")),
	                        Poste.valueOf(rs.getString("poste"))
	                ));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "Error retrieving employees: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return employees;
	    }
}


