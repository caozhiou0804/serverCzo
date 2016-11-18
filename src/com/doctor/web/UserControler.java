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

import com.doctor.service.UserService;
import com.doctor.service.WxFeaturesService;
import com.doctor.util.JSONUtil;

@Controller
@RequestMapping("Userfeature")
public class UserControler {

	@Autowired
	private UserService userService;
	@Autowired
	private WxFeaturesService wxFeaturesService;
	private Map<String, Object> map;

	/**
	 * ע���û�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping("/registeMember")
	@ResponseBody
	public Map<String, Object> registeMember(HttpServletRequest request,
			HttpServletResponse response) {
		this.map = new HashMap();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");

		if (StringUtils.isEmpty(username)) {
			this.map.put("message", "��������Ϊ��");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		try {// �����������
			username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (StringUtils.isEmpty(password)) {
			this.map.put("message", "����������");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		if (StringUtils.isEmpty(confirm_password)) {
			this.map.put("message", "������ȷ������");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}
		if (!password.equals(confirm_password)) {
			this.map.put("message", "�������벻һ��");
			this.map.put("status", false);
			return JSONUtil.jsonObjToString(this.map);
		}

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("password", password);
		try {
	//		List<Map<String, Object>> memberMap=userService.queryMembers();
			List<Map<String, Object>> memberMap=wxFeaturesService.queryMembers();
			System.out.println();
			wxFeaturesService.registeMember(m);
			this.map.put("message", "��ȡ�ɹ�");
			this.map.put("status", true);
			this.map.put("json", memberMap);
		} catch (Exception e) {
			this.map.put("message", "��ȡʧ��");
			this.map.put("status", false);
			e.printStackTrace();
		}
		return JSONUtil.jsonObjToString(this.map);
	}

	/*	*//**
	 * �����û�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	 * @RequestMapping("/insertCzoData")
	 * 
	 * @ResponseBody public Map<String, Object> insertCzoData(HttpServletRequest
	 * request, HttpServletResponse response) { this.map = new HashMap();
	 * 
	 * String name = request.getParameter("name"); String sex =
	 * request.getParameter("sex"); String mobile =
	 * request.getParameter("mobile");
	 * 
	 * if(StringUtils.isEmpty(name)){ this.map.put("message", "��������Ϊ��");
	 * this.map.put("status", false); return JSONUtil.jsonObjToString(this.map);
	 * } if(StringUtils.isEmpty(sex)){ this.map.put("message", "�Ա���Ϊ��");
	 * this.map.put("status", false); return JSONUtil.jsonObjToString(this.map);
	 * } if(StringUtils.isEmpty(mobile)){ this.map.put("message", "�绰���벻��Ϊ��");
	 * this.map.put("status", false); return JSONUtil.jsonObjToString(this.map);
	 * } try {//����������� name=new String(name.getBytes("ISO-8859-1"),"UTF-8"); }
	 * catch (UnsupportedEncodingException e1) { // TODO Auto-generated catch
	 * block e1.printStackTrace(); } try {//����������� sex=new
	 * String(sex.getBytes("ISO-8859-1"),"UTF-8"); } catch
	 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } Map<String, Object> m = new HashMap<String,
	 * Object>(); m.put("name", name); m.put("sex", sex); m.put("mobile",
	 * mobile); m.put("uid", "czodata"+System.currentTimeMillis());
	 * 
	 * try { wxFeaturesService.insertCaozhiouData(m); this.map.put("message",
	 * "�����û��ɹ�"); this.map.put("status", true); } catch (Exception e) {
	 * this.map.put("message", "�����û�ʧ��"); this.map.put("status", false);
	 * e.printStackTrace(); } return JSONUtil.jsonObjToString(this.map); }
	 *//**
	 * ɾ���û�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	 * @RequestMapping("/deleteCzoData")
	 * 
	 * @ResponseBody public Map<String, Object> deleteCzoData(HttpServletRequest
	 * request, HttpServletResponse response) { this.map = new HashMap();
	 * 
	 * String uid = request.getParameter("uid"); Map<String, Object> m = new
	 * HashMap<String, Object>();
	 * 
	 * m.put("uid", uid); try { wxFeaturesService.deleteCaozhiouData(m);
	 * this.map.put("message", "ɾ���ɹ�"); this.map.put("status", true); } catch
	 * (Exception e) { this.map.put("message", "ɾ��ʧ��"); this.map.put("status",
	 * false); e.printStackTrace(); } return JSONUtil.jsonObjToString(this.map);
	 * }
	 *//**
	 * �޸��û���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	/*
	 * @RequestMapping("/updateCzoData")
	 * 
	 * @ResponseBody public Map<String, Object> updateCzoData(HttpServletRequest
	 * request, HttpServletResponse response) { this.map = new HashMap();
	 * 
	 * String uid = request.getParameter("uid"); String name =
	 * request.getParameter("name"); String sex = request.getParameter("sex");
	 * String mobile = request.getParameter("mobile");
	 * 
	 * Map<String, Object> m = new HashMap<String, Object>();
	 * if(!StringUtils.isEmpty(uid)){ m.put("uid", uid); }
	 * if(!StringUtils.isEmpty(name)){ try {//����������� name=new
	 * String(name.getBytes("ISO-8859-1"),"UTF-8"); } catch
	 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } m.put("name", name); }
	 * if(!StringUtils.isEmpty(sex)){ try {//����������� sex=new
	 * String(sex.getBytes("ISO-8859-1"),"UTF-8"); } catch
	 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } m.put("sex", sex); }
	 * if(!StringUtils.isEmpty(mobile)){ m.put("mobile", mobile); }
	 * 
	 * try { Map<String, Object> result =
	 * wxFeaturesService.updateCaozhiouData(m); this.map.put("message", "�޸ĳɹ�");
	 * this.map.put("status", true); this.map.put("data", result); } catch
	 * (Exception e) { this.map.put("message", "�޸�ʧ��"); this.map.put("status",
	 * false); e.printStackTrace(); } return JSONUtil.jsonObjToString(this.map);
	 * }
	 */
}
