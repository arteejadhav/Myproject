package com.shop.mini_business.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shop.mini_business.model.Customer;
import com.shop.mini_business.model.Product;

public class JSonReaderWriterUtils {

	static private ObjectMapper mapper =  new ObjectMapper();
	
	private static PrintWriter pw;
	
	static public void writeProductToFile(Product p) {
	
		try {
			pw =  new PrintWriter(p.getPid()+".txt");			// to create new file
			String jsonObjectstring = mapper.writeValueAsString(p);	// to convert java object to json string
			pw.println(jsonObjectstring);								// to write to file
			pw.close();											// to close file
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static public Product searchProduct(String pid) {
		Product pt = null;
		try {
			pt = mapper.readValue(new File(pid+".txt"), Product.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pt;
	}
	
	static public void writeCustomerToFile(Customer cust) {
		
		try {
			pw =  new PrintWriter(cust.getCustID()+"_cust.txt");			// to create new file
			String jsonObjectString = mapper.writeValueAsString(cust);	// to convert java object to json string
			pw.println(jsonObjectString);								// to write to file
			pw.close();											// to close file
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static public Customer searchCustomer(String custID) {
		Customer cust = null;
		
		try {
			cust =  mapper.readValue(new File(custID+"_cust.txt"), Customer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust;
	}
	
	
}
