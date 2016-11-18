package com.doctor.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	/**
	 * 查询用户成员
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryMembers();
	/**
	 * 注册成为用户
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Object> registeMember(Map<String, Object> map);

}
