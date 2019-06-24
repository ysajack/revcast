package com.cognizant.revcast.tests;


import com.cognizant.revcast.data.AssociateDAO;
import com.cognizant.revcast.models.AllocationBean;

public class TestAllocationBean {

	public static void main(String[] args) {
		AssociateDAO adao = new AssociateDAO();
		
		AllocationBean al = new AllocationBean("A12345","P1234567","1/1/1","2/2/2",100,100);
		
		String res = adao.updateAssociateAllocation(al);
		System.out.println(res);
	}

}
