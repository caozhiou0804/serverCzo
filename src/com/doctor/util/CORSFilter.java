package com.doctor.util;

import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// CORS 的域名白名单，不支持正规，允许所有可以用 *
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 对于非简单请求，浏览器会自动发送一个 OPTIONS 请求，利用 Header 来告知浏览器可以使用的请求方式及 Header 的类型
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			response.addHeader("Access-Control-Max-Age", "1");
		}
		filterChain.doFilter(request, response);
	}
	
}
