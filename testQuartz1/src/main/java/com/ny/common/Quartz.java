package com.ny.common;

import java.util.HashSet;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
@Component
public class Quartz {
	private SchedulerFactory sf = new StdSchedulerFactory();
	private Scheduler scheduler = sf.getScheduler();
	
	public Quartz() throws Exception {
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
				.withIdentity("job1","group1")
				.build();
		
		CronTrigger ct = (CronTrigger) TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "tgroup1")
				.withSchedule(CronScheduleBuilder.cronSchedule("*/20 * * * * ?")) // 매 2초마다 실행
				.forJob(jobDetail)
				.build();
		
		Set<Trigger> tSet = new HashSet<>();
		tSet.add(ct);
		
		scheduler.scheduleJob(jobDetail, tSet, false);
		
	}
	public void startScheduler() throws Exception {
		System.out.println("<<< 포인터 스케줄러가 시작되었습니다. >>>");
		scheduler.start();
	}
	
	public void shutdownScheduler() throws Exception {
		System.out.println("<<< 포인터 스케줄러가 종료되었습니다. >>>");
		scheduler.shutdown();  
	}
	
}
