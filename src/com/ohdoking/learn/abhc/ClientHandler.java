package com.ohdoking.learn.abhc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClientHandler implements InvocationHandler {

	private Class<?> client;
	Server server;
	
	
	public ClientHandler(Class<?> client) {
		this.client = client;
	}
	
	public void init(){
		
		server = client.getAnnotation(Server.class);
	}



	@Override
	public Object invoke(Object obj, Method method, Object[] params)
			throws Throwable {
		
		String host = server.value();
		String description = server.description();
		String[] headers = server.headers();
		
		System.out.println("server url : " + server.value());
		System.out.println("server description : " + server.description());
		
		for (String string : headers) {
			System.out.println(string);
		}
		Method[] methods = client.getDeclaredMethods();
		for (Method methodz : methods) {
			
			Get get = methodz.getAnnotation(Get.class);
			
			System.out.println(method.getName());
			if(null != get){
				//get 의 정보 읽어와서 처리
				System.out.println("method annoation value : "+ get.value());
			}
		}
		
		return null;
	}

}
