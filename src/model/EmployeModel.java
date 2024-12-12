package model;

import java.util.List;

import dao.EmployeDAOimplement;
import model.Employe.Poste;
import model.Employe.Role;

public class EmployeModel {
	  private EmployeDAOimplement dao;

	    public EmployeModel(EmployeDAOimplement dao) {
	        this.dao = dao;
	    }

	    public boolean addEmployee(int id,String nom, String prenom, String email, String telephone, double salaire, Role role, Poste poste) {
	        if (salaire < 4000) {
	            System.err.println("Salary must be greater than the minimum wage.");
	            return false;
	        }
	        if (telephone.length() != 10) {
	            System.err.println("The phone number must contain exactly 10 digits.");
	            return false;
	        }
	        Employe emp = new Employe(id,nom,prenom, email, telephone, salaire, role, poste);
	        dao.addEmployee(emp);
	        return true;
	    }
	    
	    
	    public boolean deleteEmployee(int id){
	    	dao.deleteEmployee(id);
	    	return true;
	    }
 
	    public boolean modifyEmployee(int id,String nom, String prenom, String email, String telephone, double salaire, Role role, Poste poste) {
	        if (salaire < 4000) {
	            System.err.println("Salary must be greater than the minimum wage.");
	            return false;
	        }
	        if (telephone.length() != 10) {
	            System.err.println("The phone number must contain exactly 10 digits.");
	            return false;
	        }
	        Employe emp = new Employe(id,nom, prenom, email, telephone, salaire, role, poste);
	        dao.modifyEmployee(emp);
	        return true;
	    }
	    
	    public Object[][] getAllEmployees() {
	        List<Employe> employees = dao.getAllEmployees();
	        Object[][] employeeData = new Object[employees.size()][8]; 

	        for (int i = 0; i < employees.size(); i++) {
	            Employe emp = employees.get(i);
	            employeeData[i][0] = emp.getId();
	            employeeData[i][1] = emp.getNom();
	            employeeData[i][2] = emp.getPrenom();
	            employeeData[i][3] = emp.getEmail();
	            employeeData[i][4] = emp.getPhone();
	            employeeData[i][5] = emp.getSalaire();
	            employeeData[i][6] = emp.getRole();
	            employeeData[i][7] = emp.getPoste();
	        }
	        return employeeData;
	    }
}
