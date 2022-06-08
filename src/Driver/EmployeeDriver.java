package Driver;

import java.util.List;

import DataBasCrud.EmployeeCrud;
import property.Employee;

public class EmployeeDriver {
		public static void main(String[] args) {
			Employee employee=new Employee();
			employee.setId(3);
			employee.setName("pavan");
			employee.setEmail("pavan@gmail.com");
			
			EmployeeCrud crud=new EmployeeCrud();
			// crud.saveEmployee(employee);
			
//			 List<Employee> list=crud.getAllEmployee();
//			 System.out.println(list);
			Employee employee1=crud.getEmployeeById(1);
			System.out.println(employee1);
			
		}
}
