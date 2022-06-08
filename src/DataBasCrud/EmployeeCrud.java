package DataBasCrud;

import java.security.AllPermission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helperpackage.Helper;
import property.Employee;

public class EmployeeCrud {

	Helper helper = new Helper();

	Connection connection = helper.getConnectionObj();

	public void saveEmployee(Employee employee) {
		String query = "insert into employee values(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.execute();
			
			System.out.println("Data Saved");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public List<Employee> getAllEmployee()
	{
		List<Employee> list=new ArrayList<Employee>();
		String query="Select * from employee";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ArrayList<Employee> arrayList=new ArrayList<Employee>();
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				
				Employee employee=new Employee();
				employee.setId(1);
				employee.setName(name);
				employee.setEmail(email);
				list.add(employee);
				
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
		
	}
	public Employee getEmployeeById(int id)
	{
		String query="Select * from employee where id=?";
		Employee employee=new Employee();
		 
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setEmail(resultSet.getString("email"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
		
		
	}

}
