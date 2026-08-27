package com.pragma.statusprogressiontest;

import com.pragma.statusprogressiontest.application.service.TestStatusService;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import com.pragma.statusprogressiontest.infrastructure.adapter.out.TestStatusRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestStatusServiceTest {

    @Autowired
    private TestStatusService testStatusService;

    @BeforeEach
    void setUp() {
        // Ensure the repository is clear before each test
        TestStatusRepositoryImpl repository = new TestStatusRepositoryImpl();
        testStatusService = new TestStatusService(repository);
    }

    @Test
    void testSaveAndGetStatus() {
        String testId = "test1";
        TestStatus status = TestStatus.RUNNING;
        testStatusService.saveStatus(testId, status);
        Assertions.assertEquals(status, testStatusService.getStatus(testId));
    }

    @Test
    void testGetStatusNotFound() {
        String testId = "nonexistent";
        Assertions.assertNull(testStatusService.getStatus(testId));
    }

    @Test
    void testUpdateStatus() {
        String testId = "test2";
        TestStatus initialStatus = TestStatus.PENDING;
        TestStatus updatedStatus = TestStatus.COMPLETED;
        testStatusService.saveStatus(testId, initialStatus);
        testStatusService.saveStatus(testId, updatedStatus);
        Assertions.assertEquals(updatedStatus, testStatusService.getStatus(testId));
    }
}