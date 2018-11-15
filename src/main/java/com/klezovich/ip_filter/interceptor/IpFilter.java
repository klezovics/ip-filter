package com.klezovich.ip_filter.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klezovich.ip_filter.repository.IpRepository;

@Component
public class IpFilter {

	@Autowired 
	IpRepository ipRepo;
	
	public boolean isBlacklisted( String ip ) {
		
		if( ipRepo.existsById(ip) )
		   return true;
		
		return false;
	}
}
