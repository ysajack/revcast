package com.cognizant.revcast.tests;

import java.sql.SQLException;

import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.models.AllocationBean;

public class TestAssociate {

	public static void main(String[] args) {
		AssociateDAO adao = new AssociateDAO();
		
		try {
			System.out.println(adao.isAssociateExistingInProject("A12345", "P1234570"));
			//AllocationBean allocation = new AllocationBean("");
			//System.out.println(adao.addAssociateAllocation(allocation));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
