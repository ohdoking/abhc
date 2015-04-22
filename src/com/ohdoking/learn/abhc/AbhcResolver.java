package com.ohdoking.learn.abhc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

public class AbhcResolver {

	public static void resolve(Class<?> client){
		Server server = client.getAnnotation(Server.class);
		
		String host = server.value();
		String description = server.description();
		String[] headers = server.headers();
		Map<String,String> hash = token(headers);
		
		System.out.println("server url : " + server.value());
		System.out.println("server description : " + server.description());
		
		for (Map.Entry<String, String> elem : hash.entrySet()) {
			System.out.println(elem.getKey() + " >< " + elem.getValue());
		}
		/*for (String string : headers) {
			System.out.println(string);
		}*/
		Method[] methods = client.getDeclaredMethods();
		for (Method method : methods) {
			
			Get get = method.getAnnotation(Get.class);
			
			System.out.println(method.getName());
			if(null != get){
				//get 의 정보 읽어와서 처리
				System.out.println("method annoation value : "+ get.value());
			}
		}
	}
	
	public static Map<String,String> token(String[] something){
		Map<String,String> hash = new HashMap<String, String>();  
		for (String string : something) {
			String[] tokenValue = string.split(":");
			
			String key = tokenValue[0];
			String value = tokenValue[1];
		
			hash.put(key, value);
		}
		return hash;
	}
	
	/*
	 * source(.java)               ->              compile time (.class) -> runtime(jvm)
	 * Annotation(보통여기까지만)               
	 * Retention										Retention.comple..   
	 */
	public static void main(String[] args) {
		
		resolve(AbhcClient.class);
	}
}
