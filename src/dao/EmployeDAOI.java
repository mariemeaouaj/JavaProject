package dao;



import java.util.List;

import model.Employe;


public interface EmployeDAOI {
	
	public void addEmployee(Employe emp);
	public void deleteEmployee(int id);
	public void modifyEmployee(Employe emp);
	public List<Employe> getAllEmployees();


	
}

