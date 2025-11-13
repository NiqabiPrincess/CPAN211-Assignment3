package assignment3;

import java.io.*;
import java.util.*;


public class SalesFileReader {
	
	private Map<String, Integer> productMap = new HashMap<>();
	private Map<String, Double> customerMap = new HashMap<>();
	
	public void readSalesFile(String filename) {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			
			while ((line = reader.readLine()) != null) {
				if (line.trim().equals("")) {
					continue;
				}
				
				String[] parts = line.trim().split("\\s+");
				
				if (parts.length != 7) {
					System.out.println("Invalid Line: " + line );
					continue;
				}
				
				 String customerID = parts[0];   
	             String firstName = parts[1];    
	             String lastName = parts[2];    
	             String productID = parts[3];    
	             String productName = parts[4];  
	             double price = Double.parseDouble(parts[5]); 
	             int quantity = Integer.parseInt(parts[6]);
	             
	             
	             int currentProductCount = 0;
	             if(productMap.get(productID) != null) {
	            	 currentProductCount = productMap.get(productID);
	             }
	             
	             productMap.put(productID, currentProductCount + quantity);
	             
	             double currentCustomerTotal = 0.0;
	             if (customerMap.get(customerID) != null) {
	            	 currentCustomerTotal = customerMap.get(customerID);
	             }
	             
	             customerMap.put(customerID, currentCustomerTotal + (price * quantity));
				
			}
			reader.close();

		}
		
		catch (Exception e){
			System.out.println("Error reading file: " + filename);
            return;
		}
		
		System.out.println("Products purchased counts:");
        for (String pid : productMap.keySet()) {
            System.out.println(pid + ": " + productMap.get(pid));
        }
        
        System.out.println("\nCustomers total bills:");
        for (String cid : customerMap.keySet()) {
            System.out.println(cid + ": $" + customerMap.get(cid));
        }
		
	}
	


}
