package com.example.demo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component("HelloTasklet1")
@StepScope
public class HelloTasklet implements Tasklet {

	// The execute method prints "Hello, Tasklet!" to the console.
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Hello, Tasklet Modified!!!");
		return RepeatStatus.FINISHED;
	}
	
}
