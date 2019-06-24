package com.cognizant.revcast.tests;

import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.models.Associate;

public class TestAddAssociate {

	public static void main(String[] args) {
		AssociateDAO adao = new AssociateDAO();
		
		/*
		 * 
		 	String associateId;
			String associateName;
			String designation;
			String status;
			String revcat;
			String practice;
			String onsiteOffshore;
			String revType;
			String projectStart;
			String projectEnd;
			int allocation;
			int rate;
			String projectId;
		 */
		
		Associate associate = new Associate("P123","Apple","SA","Active","TMM","QEA","Onsite","TM","1/1/19","TBD",100,100,"P1234567");
		
		System.out.println("Add Associate: " + adao.addAssociate(associate));
	}

}
