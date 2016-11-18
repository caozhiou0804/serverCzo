package com.doctor.mapper;

import java.util.List;
import java.util.Map;

public interface FeaturesMapper {

	public List<Map<String, Object>> getCaozhiouData(Map<String, Object> map);
	public Map<String, Object> insertCaozhiouData(Map<String, Object> map);
	public void deleteCaozhiouData(Map<String, Object> map);
	public Map<String, Object> updateCaozhiouData(Map<String, Object> map);
	public List<Map<String, Object>> queryMembers();
	
	public Map<String, Object> registeMember(Map<String, Object> map);
}
