package com.qfedu.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.house.domain.District;
import com.qfedu.house.mapper.DistrictMapper;
import com.qfedu.house.service.DistrictService;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {
	 @Autowired
	 private DistrictMapper distMapper;
	
	@Override
	@Async("taskExecutor")
	public void bar() {
		System.out.println("bar: " + Thread.currentThread().getName());
	}
	
	@Override
	public List<District> listAllDistricts() {
		System.out.println("list: " + Thread.currentThread().getName());
		return distMapper.findAll();
	}
	
	@Override
	@Scheduled(cron = "20 * * * * ?")
	public void foo() {
		System.out.println("foo: " + Thread.currentThread().getName());
	}

}
