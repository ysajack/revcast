package com.cognizant.revcast.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.Test;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

import com.cognizant.revcast.data.ProjectDAO;
import com.cognizant.revcast.models.ProjectBean;

public class TestAPI {

	@Test
	public void testAllProjectBeans() throws ClassNotFoundException, SQLException {
		Client client = ClientBuilder.newClient();
		ProjectDAO prjdao = new ProjectDAO();
		List<ProjectBean> prjList = prjdao.getAllProjectBeans();

		WebTarget wt = client.target("http://localhost:8181/cognizant/ProjectService");
		WebTarget projWebTarget = wt.path("projects");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_XML);
		ProjectBean[] response = invocationBuilder.get(ProjectBean[].class);

		assertEquals(3, response.length);
		for (int i = 0; i < response.length; i++) {
			// System.out.println(prj.getProjectName());
			/*assertEquals(prjList.get(i).getBio(), response[i].getBio());
			assertEquals(prjList.get(i).getProjectId(), response[i].getProjectId());
			assertEquals(prjList.get(i).getProjectName(), response[i].getProjectName()); */
			assertThat(prjList.get(i),sameBeanAs(response[i]));
		} 

		// assertThat(prjList,containsInAnyOrder(Arrays.asList(response)));
	
	}	

	@Test
	public void testProjectBeanById() throws ClassNotFoundException, SQLException {
		Client client = ClientBuilder.newClient();
		ProjectDAO prjdao = new ProjectDAO();
		ProjectBean prj = prjdao.getProjectBeanById("P1234567");

		WebTarget wt = client.target("http://localhost:8181/cognizant/ProjectService");
		WebTarget projWebTarget = wt.path("projects/P1234567");
		Invocation.Builder invocationBuilder = projWebTarget.request(MediaType.APPLICATION_XML);
		ProjectBean response = invocationBuilder.get(ProjectBean.class);

		// System.out.println(prj.getProjectName());
	/*	assertEquals(prj.getBio(), response.getBio());
		assertEquals(prj.getProjectId(), response.getProjectId());
		assertEquals(prj.getProjectName(), response.getProjectName()); */

		// assertThat(prjList,containsInAnyOrder(Arrays.asList(response)));
		assertThat(prj,sameBeanAs(response));
	}

}
