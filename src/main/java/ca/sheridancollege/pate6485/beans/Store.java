package ca.sheridancollege.pate6485.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Store {
	
	private int id;
	private String storeName;
	private String storeAddress;
	private double storeOpeningHours;
	private int noOfEmployees;
	private String description;
	
	private List<Employee> employeeList;
}
