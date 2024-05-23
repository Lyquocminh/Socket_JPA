package jUnitTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import services.EntityManagerFactoryUtil;

public class JUnitTest {
	private static EntityManagerFactoryUtil mangerFactoryUtil;
	private static EntityManager entityManager;

	@BeforeAll
	static void setup() {
		mangerFactoryUtil = new EntityManagerFactoryUtil();
		entityManager = mangerFactoryUtil.getEnManager();
	}

	@Test
	@DisplayName("findCourseByID")
	void findCourseByID() {
	}

	@AfterAll
	public static void afterAll() {
		mangerFactoryUtil.close();
	}
}
