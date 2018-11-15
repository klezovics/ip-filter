package com.klezovich.ip_filter.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface IpRepository extends CrudRepository<Ip,String>  {

	@Cacheable("ips")
	public boolean existsById( String id );
}
