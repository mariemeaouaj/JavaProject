package defaultpackage;

import controller.EmployeController;
import dao.EmployeDAOimplement;
import model.EmployeModel;
import view.EmployeView;

public class Main {
	public static void main(String[] args) {
		EmployeDAOimplement dao = new EmployeDAOimplement();
		EmployeModel model = new EmployeModel(dao);
		EmployeView view = new EmployeView();
		EmployeController controller = new EmployeController(view,model);
	}
}