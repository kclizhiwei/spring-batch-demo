package com.batch.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:batch.xml"})
public class SimpleBatchTest {
	private static final Logger logger = LoggerFactory.getLogger(SimpleBatchTest.class);
	@Resource
	private JobLauncher jobLauncher;
	@Resource
	private Job helloWorldJob;
	
	@Resource
	private Job csvJob;
	
	@Test
	public void testBatch() {
		
		try {
			jobLauncher.run(helloWorldJob, new JobParameters());
		} catch (JobExecutionAlreadyRunningException e) {
			logger.error("",e);
		} catch (JobRestartException e) {
			logger.error("",e);
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.error("",e);
		} catch (JobParametersInvalidException e) {
			logger.error("",e);
		}
	}
	@Test
	public void testCsv() {
		try {
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("commit-interval", new JobParameter(1L));
			JobParameters jobParameters = new JobParameters(params);
			jobLauncher.run(csvJob, jobParameters);
		} catch (Exception e) {
			logger.error("",e);
		}
	}
	
}
