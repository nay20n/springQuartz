package com.ny.common;

import java.time.ZonedDateTime;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ny.service.MemberService;

public class MyJob implements Job{

	@Autowired
	MemberService mSvc;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		int cnt = mSvc.updateAllPoint();
		
		
        
		
		System.out.println("Job이 실행됨 : " + ZonedDateTime.now() + "/ "+cnt+"명에게 포인터 부여(1점)" );
		
	}

}
