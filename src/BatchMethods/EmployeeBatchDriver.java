package BatchMethods;

import java.util.ArrayList;

import property.Employee;

public class EmployeeBatchDriver {
public static void main(String[] args) {
	ArrayList<Employee > list=new ArrayList();
	Employee employee=new Employee();
	
	employee.setId(1);
	employee.setName("Kumara");
	employee.setEmail("blkumara701@gmail.com");
	
Employee employee1=new Employee();
	
	employee1.setId(2);
	employee1.setName("varun");
	employee1.setEmail("varun@gmail.com");
	
Employee employee2=new Employee();
	
	employee2.setId(3);
	employee2.setName("pavan");
	employee2.setEmail("pavan@gmail.com");
	
	list.add(employee);
	list.add(employee1);
	list.add(employee2);
	
	EmployeeBatch employeeBatch=new EmployeeBatch();
	employeeBatch.addEmployeeBatch(list);
	
	
}
}
