package com.pragma.statusprogressiontest.infrastructure.adapter.out;

import com.pragma.statusprogressiontest.application.port.out.TestStatusRepository;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TestStatusRepositoryImpl implements TestStatusRepository {
    private final ConcurrentHashMap<String, TestStatus> statusMap = new ConcurrentHashMap<>();

    @Override
    public void saveStatus(String testId, TestStatus status) {
        statusMap.put(testId, status);
    }

    @Override
    public TestStatus getStatus(String testId) {
        return statusMap.get(testId);
    }
}