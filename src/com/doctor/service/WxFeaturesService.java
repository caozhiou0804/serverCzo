package com.doctor.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface WxFeaturesService {
	/**
	 * getCaozhiouData获取caozhiou表里的数据
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getCaozhiouData(Map<String, Object> map);
	public Map<String, Object> insertCaozhiouData(Map<String, Object> map);
	public void deleteCaozhiouData(Map<String, Object> m);
	public Map<String, Object> updateCaozhiouData(Map<String, Object> m);
	
	public List<Map<String, Object>> queryMembers();
	public Map<String, Object> registeMember(Map<String, Object> m);
}
