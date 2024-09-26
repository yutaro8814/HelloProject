package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringConfig {

	// The JobLauncher, JobRepository, and PlatformTransactionManager beans are injected into the SpringConfig class.
	private final JobLauncher jobLauncher;
	
	// The JobRepository bean is injected into the SpringConfig class.
	private final JobRepository jobRepository;
	
	// The PlatformTransactionManager bean is injected into the SpringConfig class.
	private final PlatformTransactionManager transactionManager;

	public SpringConfig(JobLauncher jobLauncher, JobRepository jobRepository,
			PlatformTransactionManager transactionManager) {
		this.jobLauncher = jobLauncher;
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
	}
	
	// The Tasklet beans are injected into the SpringConfig class.
	@Qualifier("HelloTasklet1")
	@Autowired
	private Tasklet tasklet1;
	
	@Qualifier("HelloTasklet2")
	@Autowired
	private Tasklet tasklet2;
	
	@Bean
	Job Job() {
		return new JobBuilder("HelloJob", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(HelloStep1())
				.next(HelloStep2())
				.build();
	}

    @Bean
    Step HelloStep1() {
		return new StepBuilder("HelloTasklet1",jobRepository)
				.tasklet(tasklet1,transactionManager)
				.build();
	}

    @Bean
    Step HelloStep2() {
		return new StepBuilder("HelloTasklet2",jobRepository )
				.tasklet(tasklet2,transactionManager)
				.build();
	}
}
