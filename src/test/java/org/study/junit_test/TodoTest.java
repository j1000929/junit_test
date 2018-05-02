package org.study.junit_test;

import org.junit.Assert;
import org.junit.Test;
import org.study.junit_test.dao.DataServer;
import org.study.junit_test.service.TodoService;

public class TodoTest {

	@Test
	public void testMakeConnect() {
		DataServer server = new DataServer();

		Assert.assertNotNull(server.getConn());
	}

	@Test
	public void testLogin() {
		String username = "admin";
		String password = "admin11";

		TodoService service = new TodoService();
		Assert.assertTrue(service.login(username, password));

		Assert.assertFalse(service.login("babo", "abc"));
	}

	@Test
	public void testTodo() {
		TodoService service = new TodoService();
		service.addTodo("jungmin", "blahblab");

		service.retrieveTodo("jungmin");

		Assert.assertEquals("blahblah", service.retrieveTodo("jungmin"));
	}

}
