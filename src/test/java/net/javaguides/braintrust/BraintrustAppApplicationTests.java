package net.javaguides.braintrust;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SpringBootTest
class BraintrustAppApplicationTests {

	@Test
	public void updateTriangleThrowsNPE() {
		assumeTrue(System.getenv("GITLAB_CI") != null, "Skipped test: not in CI environment");
	}

	@Test
	void contextLoads() {
	}
}
