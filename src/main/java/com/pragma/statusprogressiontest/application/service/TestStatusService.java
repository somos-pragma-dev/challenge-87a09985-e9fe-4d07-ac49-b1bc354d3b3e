package com.pragma.statusprogressiontest.application.service;

import com.pragma.statusprogressiontest.application.port.out.TestStatusRepository;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.stereotype.Service;

@Service
public class TestStatusService {
    private final TestStatusRepository testStatusRepository;

    public TestStatusService(TestStatusRepository testStatusRepository) {
        this.testStatusRepository = testStatusRepository;
    }

    public void saveStatus(String testId, TestStatus status) {
        testStatusRepository.saveStatus(testId, status);
    }

    public TestStatus getStatus(String testId) {
        return testStatusRepository.getStatus(testId);
    }
}