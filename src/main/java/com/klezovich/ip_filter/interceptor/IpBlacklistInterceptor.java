package com.klezovich.ip_filter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class IpBlacklistInterceptor implements HandlerInterceptor {

  @Autowired
  IpFilter ipFilter;
  

  private static String getClientIp( HttpServletRequest request) {

      String remoteAddr = "";

      if (request != null) {
          remoteAddr = request.getHeader("X-FORWARDED-FOR");
          if (remoteAddr == null || "".equals(remoteAddr)) {
              remoteAddr = request.getRemoteAddr();
          }
      }

      return remoteAddr;
  }
	
   @Override
   public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      
	  String ip = getClientIp(request);
	  
	  if( ipFilter.isBlacklisted(ip) ) {
		  response.getWriter().write("Your ip (" + ip +") has been blacklisted" ); 
		  return false;
	  }
	   
      return true;
   }
   
   @Override
   public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, 
      ModelAndView modelAndView) throws Exception {}
   
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
      Object handler, Exception exception) throws Exception {}
}