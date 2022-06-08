package BatchMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import helperpackage.Helper;
import property.Employee;


public class EmployeeBatch {
	
	Helper h=new Helper();
	
	Connection connection=h.getConnectionObj();
	
	public void addEmployeeBatch(List<Employee> list)
	{
	String query="insert into employee values(?,?,?)";
	
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		for (Employee employee : list) {
			preparedStatement.setInt(1,employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getEmail());
			
			preparedStatement.addBatch();
			System.out.println("Employe with id:"+employee.getId()+"is addto batch");
		}
		preparedStatement.executeBatch();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	

}
