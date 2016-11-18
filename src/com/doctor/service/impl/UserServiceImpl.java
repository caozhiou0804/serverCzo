package com.doctor.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.doctor.mapper.FeaturesMapper;
import com.doctor.mapper.UserMapper;
import com.doctor.service.UserService;

@Component("UserService")
@Transactional
public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<Map<String, Object>> queryMembers() {
		// TODO Auto-generated method stub
		return userMapper.queryMembers();
	}

	@Override
	public Map<String, Object> registeMember(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
