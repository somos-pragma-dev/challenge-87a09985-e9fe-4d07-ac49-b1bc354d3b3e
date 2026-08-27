package com.pragma.statusprogressiontest.application.port.out;

import com.pragma.statusprogressiontest.domain.model.TestStatus;

public interface TestStatusRepository {
    void saveStatus(String testId, TestStatus status);
    TestStatus getStatus(String testId);
}