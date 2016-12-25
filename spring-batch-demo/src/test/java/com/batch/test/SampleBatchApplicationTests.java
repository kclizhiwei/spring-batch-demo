package com.batch.test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.OutputCapture;

import com.spring.batch.demo.SampleBatchApplication;

public class SampleBatchApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		assertThat(SpringApplication
				.exit(SpringApplication.run(SampleBatchApplication.class))).isEqualTo(0);
		String output = this.outputCapture.toString();
		assertThat(output).contains("completed with the following parameters");
	}

}
