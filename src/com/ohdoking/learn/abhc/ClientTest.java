package com.ohdoking.learn.abhc;

import java.lang.reflect.Proxy;

public class ClientTest {

	public static void main(String[] args) {
		AbhcClient handler = (AbhcClient) Proxy.newProxyInstance(AbhcClient.class.getClassLoader(), new Class<?>[]{AbhcClient.class}, new ClientHandler(AbhcClient.class));
		
		handler.getUser("nnoco");
	}
}
