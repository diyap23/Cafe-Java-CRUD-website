package ca.sheridancollege.pate6485.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import ca.sheridancollege.pate6485.beans.Store;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StoreRepository {
	
	private NamedParameterJdbcTemplate jdbc;
	
	public void addStore(Store s) {
	    MapSqlParameterSource params = new MapSqlParameterSource();    
	    String query = "INSERT INTO store(store_name, store_address, store_opening_hours, no_employees, description)"
	            + " VALUES (:name, :address, :hours, :employees, :descr)";
	    
	    params.addValue("name", s.getStoreName());
	    params.addValue("address", s.getStoreAddress());
	    params.addValue("hours", s.getStoreOpeningHours());
	    params.addValue("employees", s.getNoOfEmployees());
	    params.addValue("descr", s.getDescription());
	    jdbc.update(query, params);
	}
	
	public ArrayList<Store> getStore(){
		
		MapSqlParameterSource params = new MapSqlParameterSource();	
		
		String query = "SELECT * FROM store";
		
		ArrayList<Store> stores  = (ArrayList<Store>)jdbc.query(query, params, new BeanPropertyRowMapper<Store>(Store.class));
		
		return stores;
	}
	
	public Store getStoreById(int id) {
	    
	    ArrayList<Store> stores = new ArrayList<>();
	    
	    String query = "SELECT * FROM store WHERE id=:id";  
	    MapSqlParameterSource params = new MapSqlParameterSource();    
	    params.addValue("id", id); 
	    
	    
	    List<Map<String,Object>> rows = jdbc.queryForList(query, params);
	    
	    for(Map<String, Object> row : rows) {
	        Store s = new Store();
	        
	        s.setId((Integer)row.get("id")); 
	        s.setStoreName((String)row.get("store_name"));
	        s.setStoreAddress((String)row.get("store_address"));
	        s.setStoreOpeningHours((Double)row.get("store_opening_hours"));
	        s.setNoOfEmployees((Integer)row.get("no_employees"));
	        s.setDescription((String)row.get("description"));
	        
	        stores.add(s);
	    }
	    
	    if(stores.size()>0) {
	        return stores.get(0);
	    } else {
	        return null;
	    }
	}

	public void deleteStore(int id) {
	    MapSqlParameterSource params = new MapSqlParameterSource();
	    
	    String query = "DELETE FROM store WHERE id=:id";  
	    
	    params.addValue("id", id);
	    
	    jdbc.update(query, params);
	}

}
