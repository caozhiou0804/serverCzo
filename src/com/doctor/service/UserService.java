package com.doctor.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	/**
	 * ��ѯ�û���Ա
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryMembers();
	/**
	 * ע���Ϊ�û�
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Object> registeMember(Map<String, Object> map);

}
