package ca.sheridancollege.pate6485.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.pate6485.beans.Employee;
import ca.sheridancollege.pate6485.beans.Store;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EmployeeRepository {
	
private NamedParameterJdbcTemplate jdbc;
	
	public void addEmployee(Employee e) {
		MapSqlParameterSource params = new MapSqlParameterSource();	
		String query = "INSERT INTO employee(employee_name, shift_date, shift_time, job_title, salary, working_hours, store_id)"
				+ " VALUES (:name, :date, :time, :jobtitle, :salary, :workinghrs, :storeid)";
		params.addValue("name", e.getEmployeeName());
		params.addValue("date", e.getShiftDate());
		params.addValue("time", e.getShiftTime());
		params.addValue("jobtitle", e.getJobTitle());
		params.addValue("salary", e.getSalary());
		params.addValue("workinghrs", e.getWorkingHours());
		params.addValue("storeid", e.getStore().getId());
		
		jdbc.update(query, params);
	}
	
	public ArrayList<Employee> getEmployee(){
		
		MapSqlParameterSource params = new MapSqlParameterSource();	
		
		String query = "SELECT * FROM employee";
		
		ArrayList<Employee> employees  = (ArrayList<Employee>)jdbc.query(query, params, new BeanPropertyRowMapper<Employee>(Employee.class));
		
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
	    MapSqlParameterSource params = new MapSqlParameterSource();
	    String query = "SELECT * FROM employee WHERE id = :id";  
	    params.addValue("id", id);

	    List<Employee> employees = jdbc.query(query, params, new BeanPropertyRowMapper<>(Employee.class));

	    if (employees.size() > 0) {
	        return employees.get(0);
	    } else {
	        return null;
	    }
	}

	
	public void editEmployee(Employee e) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "UPDATE employee SET employee_name = :name, shift_date = :date, shift_time = :time, job_title = :jobtitle, salary = :salary, working_hours = :workinghrs, store_id = :storeid WHERE id = :id";
		
		params.addValue("id", e.getId());
        params.addValue("name", e.getEmployeeName());
        params.addValue("date", e.getShiftDate());
        params.addValue("time", e.getShiftTime());
        params.addValue("jobtitle", e.getJobTitle());
        params.addValue("salary", e.getSalary());
        params.addValue("workinghrs", e.getWorkingHours());
        params.addValue("storeid", e.getStore().getId());
        jdbc.update(query, params);
	}
	
	public void deleteEmployee(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		String query = "DELETE FROM employee WHERE id=:id";
		
		params.addValue("id", id);
		
		jdbc.update(query, params);
	}
	
	public ArrayList<Employee> getEmployeeByStoreId(int storeId){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		String query = "SELECT * FROM employee WHERE store_id = :storeId";
		params.addValue("storeId", storeId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, params);
		ArrayList<Employee> employeeList = new ArrayList<>();
		for (Map<String, Object> row : rows) {
            Employee e = new Employee();
            e.setId((Integer) row.get("id"));
            e.setEmployeeName((String) row.get("employee_name"));
            e.setShiftDate(((java.sql.Date) row.get("shift_date")).toLocalDate());
            e.setShiftTime(((java.sql.Time) row.get("shift_time")).toLocalTime());
            e.setJobTitle((String) row.get("job_title"));
            e.setSalary((Double) row.get("salary"));
            e.setWorkingHours((Integer) row.get("working_hours"));
            
            Store s = new Store();
            s.setId((Integer)row.get("store_id"));
            s.setStoreName((String) row.get("store_name")); 
            e.setStore(s);
            employeeList.add(e);

	}
		
		return employeeList;
	
	}
}
	
