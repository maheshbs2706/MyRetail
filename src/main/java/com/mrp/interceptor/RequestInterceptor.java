
package com.mrp.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mrp.constants.GlobalConstants;

@Component
public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uuid = UUID.randomUUID().toString();
		request.setAttribute(GlobalConstants.TRACKID, uuid);
		MDC.put(GlobalConstants.TRACKID, uuid);
		return true;
	}
}
