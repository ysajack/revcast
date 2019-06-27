package com.cognizant.revcast.tests;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;


import com.cognizant.revcast.data.AssociateDAO;


public class TestAssociate {

	public static void main(String[] args) {
		AssociateDAO adao = new AssociateDAO();
		
		HashMap<LinkedList<String>,String> hm = new HashMap<LinkedList<String>,String>();
		LinkedList<String> ls = new LinkedList<String>();
		
		ls.add("1");
		ls.add("2");
		
		hm.put(ls, "One");
		hm.put(ls, "Two");
		
	
		
	/*	
		try {
			System.out.println(adao.isAssociateExistingInProject("A12345", "P1234570"));
			//AllocationBean allocation = new AllocationBean("");
			//System.out.println(adao.addAssociateAllocation(allocation));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

}
