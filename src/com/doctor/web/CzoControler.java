package com.doctor.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doctor.service.WxFeaturesService;
import com.doctor.util.JSONUtil;

@Controller
@RequestMapping("CZOfeature")
public class CzoControler {
	
	@Autowired
	private WxFeaturesService wxFeaturesService;
	
	private Map<String, Object> map;
	@RequestMapping("/queryCzoData")
	@ResponseBody
	public Map<String, Object> czoService(HttpServletRequest request,
			HttpServletResponse response) {
		this.map = new HashMap();
		
		List<Map<String, Object>> m = new ArrayList<Map<String, Object>>();
		try {
			m = wxFeaturesService.getCaozhiouData(new HashMap());
			this.map.put("message", "获取成功");
			this.map.put("status", true);
			this.map.put("json",JSONUtil.jsonArryToString(m));
		} catch (Exception e) {
			this.map.put("message", "获取失败");
			this.map.put("status", false);
			e.printStackTrace();
		}
		return JSONUtil.jsonObjToString(this.map);
	}
	
	
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/insertCzoData")
	@ResponseBody
	public Map<String, Object> insertCzoData(HttpServletRequest request,
			HttpServletResponse response) {
		this.map = new HashMap();
		
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		
		if(StringUtils.isEmpty(name)){
			this.map.put("message", "姓名不能为空");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		if(StringUtils.isEmpty(sex)){
			this.map.put("message", "性别不能为空");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		if(StringUtils.isEmpty(mobile)){
			this.map.put("message", "电话号码不能为空");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		try {//解决中文乱码
			name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {//解决中文乱码
			sex=new String(sex.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("name", name);
		m.put("sex", sex);
		m.put("mobile", mobile);
		m.put("uid", "czodata"+System.currentTimeMillis());
		
		try {
			wxFeaturesService.insertCaozhiouData(m);
			this.map.put("message", "新增用户成功");
			this.map.put("status", true);
		} catch (Exception e) {
			this.map.put("message", "新增用户失败");
			this.map.put("status", false);
			e.printStackTrace();
		}
		return JSONUtil.jsonObjToString(this.map);
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteCzoData")
	@ResponseBody
	public Map<String, Object> deleteCzoData(HttpServletRequest request,
			HttpServletResponse response) {
		this.map = new HashMap();
		
		String uid = request.getParameter("uid");
		Map<String, Object> m = new HashMap<String, Object>();
		
		m.put("uid", uid);
		try {
			wxFeaturesService.deleteCaozhiouData(m);
			this.map.put("message", "删除成功");
			this.map.put("status", true);
		} catch (Exception e) {
			this.map.put("message", "删除失败");
			this.map.put("status", false);
			e.printStackTrace();
		}
		return JSONUtil.jsonObjToString(this.map);
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateCzoData")
	@ResponseBody
	public Map<String, Object> updateCzoData(HttpServletRequest request,
			HttpServletResponse response) {
		this.map = new HashMap();
		
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String mobile = request.getParameter("mobile");
		
		Map<String, Object> m = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(uid)){
			m.put("uid", uid);
		}
		if(!StringUtils.isEmpty(name)){
			try {//解决中文乱码
				name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			m.put("name", name);
		}
		if(!StringUtils.isEmpty(sex)){
			try {//解决中文乱码
				sex=new String(sex.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			m.put("sex", sex);
		}
		if(!StringUtils.isEmpty(mobile)){
			m.put("mobile", mobile);
		}
		
		try {
			Map<String, Object> result =  wxFeaturesService.updateCaozhiouData(m);
			this.map.put("message", "修改成功");
			this.map.put("status", true);
			this.map.put("data", result);
		} catch (Exception e) {
			this.map.put("message", "修改失败");
			this.map.put("status", false);
			e.printStackTrace();
		}
		return JSONUtil.jsonObjToString(this.map);
	}
}
