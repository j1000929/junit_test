package org.study.junit_test.service;

import org.study.junit_test.dao.DataServer;

public class TodoService {

	private DataServer server;

	public TodoService() {
		server = new DataServer();
	}

	public boolean login(String username, String password) {
		return server.login(username, password);
	}

	public boolean addTodo(String username, String todo) {
		return server.updateTodo(username, todo);
	}

	public String retrieveTodo(String username) {
		return server.readTod(username);
	}
}
