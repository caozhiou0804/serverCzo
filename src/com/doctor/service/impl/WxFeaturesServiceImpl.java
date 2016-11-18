package com.doctor.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.doctor.mapper.FeaturesMapper;
import com.doctor.service.WxFeaturesService;

@Component("WxFeaturesService")
@Transactional
public class WxFeaturesServiceImpl implements WxFeaturesService {

	private FeaturesMapper featuresMapper;
	private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public FeaturesMapper getFeaturesMapper() {
		return featuresMapper;
	}

	public void setFeaturesMapper(FeaturesMapper featuresMapper) {
		this.featuresMapper = featuresMapper;
	}

	@Override
	public List<Map<String, Object>> getCaozhiouData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return featuresMapper.getCaozhiouData(map);
	}

	@Override
	public Map<String, Object> insertCaozhiouData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return featuresMapper.insertCaozhiouData(map);
	}

	@Override
	public void deleteCaozhiouData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		featuresMapper.deleteCaozhiouData(map);
	}

	@Override
	public Map<String, Object> updateCaozhiouData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return featuresMapper.updateCaozhiouData(map);
	}

	@Override
	public List<Map<String, Object>> queryMembers() {
		// TODO Auto-generated method stub
		return featuresMapper.queryMembers();
	}

	@Override
	public Map<String, Object> registeMember(Map<String, Object> m) {
		// TODO Auto-generated method stub
		return featuresMapper.registeMember(m);
	}

}
