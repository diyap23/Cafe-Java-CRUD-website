package ca.sheridancollege.pate6485.beans;


import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Employee {
	
	private int id;
	private String employeeName;
	private Store store;
	private LocalDate shiftDate;
	private LocalTime shiftTime;
	private String jobTitle;
	private double salary;
	private int workingHours;
	
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
}
