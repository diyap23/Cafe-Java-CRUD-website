package ca.sheridancollege.pate6485.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.pate6485.beans.Employee;
import ca.sheridancollege.pate6485.beans.Store;
import ca.sheridancollege.pate6485.repositories.EmployeeRepository;
import ca.sheridancollege.pate6485.repositories.StoreRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class StoreController {
	
	private StoreRepository storeRepo;
	private EmployeeRepository employeeRepo;

	@GetMapping("/")
	public String goHomePage() {
		return "HomePage.html";
	}
	
	@GetMapping("/addStore")
	public String goStoreAddPage(Model model) {
		model.addAttribute("store", new Store());
		
		return "AddStore.html";
	}
	
	@GetMapping("/addEmployee")
	public String goEmployeeAddPage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("stores", storeRepo.getStore());
		return "AddEmployee.html";
	}
	
	 @PostMapping("/addStore")
	    public String addStore(@ModelAttribute Store store) {
	        storeRepo.addStore(store);
	        return "redirect:/addStore";
	    }
	 
	 @PostMapping("/addEmployee")
	    public String addEmployee(@ModelAttribute Employee employee,
	    		@RequestParam int storeId) {
		 
		 Store selectedStore = storeRepo.getStoreById(storeId);
		 
		 employee.setStore(selectedStore);
	     employeeRepo.addEmployee(employee);
	        
	     return "redirect:/addEmployee";
	    }
	 
	 @GetMapping("/viewStores")
	    public String viewStoresWithEmployees(Model model) {
	        ArrayList<Store> stores = storeRepo.getStore();
	        for (Store s : stores) {
	            ArrayList<Employee> emps = employeeRepo.getEmployeeByStoreId(s.getId());
	            s.setEmployeeList(emps);
	            s.setNoOfEmployees(emps.size());
	        }
	        model.addAttribute("stores", stores);
	        return "ViewPage.html";
	    }
	 
	 @GetMapping("/viewAll")
	 public String viewAllStoresAndEmployees(Model model) {
	     ArrayList<Store> stores = storeRepo.getStore();
	     ArrayList<Employee> allEmployees = new ArrayList<>();

	     for (Store store : stores) {
	         ArrayList<Employee> emps = employeeRepo.getEmployeeByStoreId(store.getId());
	         store.setNoOfEmployees(emps.size());

	         for (Employee e : emps) {
	             e.getStore().setStoreName(store.getStoreName()); 
	             allEmployees.add(e);
	         }
	     }

	     model.addAttribute("stores", stores);
	     model.addAttribute("employees", allEmployees);

	     return "ViewAll.html";
	 }
	 
	 @GetMapping("/editEmployee/{id}")
	    public String goEditEmployeePage(@PathVariable int id, Model model) {
	        Employee e = employeeRepo.getEmployeeById(id);
	        model.addAttribute("employee", e);
	        model.addAttribute("stores", storeRepo.getStore());
	        return "EditEmployee.html";
	    }
	 
	 @PostMapping("/editEmployee")
	    public String editEmployee(@ModelAttribute Employee employee,
                @RequestParam int storeId) {
		 
		 Store s = storeRepo.getStoreById(storeId);
		    employee.setStore(s);
		    employeeRepo.editEmployee(employee);
		    return "redirect:/viewStores";
	    }
	 
	 @GetMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable int id) {
	        employeeRepo.deleteEmployee(id);
	        return "redirect:/viewStores";
	    }
	 
}
