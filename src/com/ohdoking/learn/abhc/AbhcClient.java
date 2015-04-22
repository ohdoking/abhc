package com.ohdoking.learn.abhc;

import java.util.List;

/*
 * Server{
 *  value;
 * }
 *String value
 */

//value 이름 일때만 생략해서 적을 수 있다. 그리고 2개이상이 되면 생략 불가
@Server(value = "abhc.com",description = "annotation based ... ",headers={"Authorization : ohdoking","Agent : Chorome"})
public interface AbhcClient {

	/*
	 * http://abhc.com.users/123
	 */
	@Get("/users/{id}")
	public User getUser(@PathVariable("id")String id);
	
	public List<User> getUsers();
	
	public void createUser(User user);
}
