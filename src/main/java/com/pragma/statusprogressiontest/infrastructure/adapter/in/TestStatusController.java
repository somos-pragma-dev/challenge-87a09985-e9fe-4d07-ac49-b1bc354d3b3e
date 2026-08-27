package com.pragma.statusprogressiontest.infrastructure.adapter.in;

import com.pragma.statusprogressiontest.application.service.TestStatusService;
import com.pragma.statusprogressiontest.domain.model.TestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-status")
public class TestStatusController {
    private final TestStatusService testStatusService;

    @Autowired
    public TestStatusController(TestStatusService testStatusService) {
        this.testStatusService = testStatusService;
    }

    @PostMapping("/save")
    public void saveStatus(@RequestParam String testId, @RequestParam TestStatus status) {
        testStatusService.saveStatus(testId, status);
    }

    @GetMapping("/get/{testId}")
    public TestStatus getStatus(@PathVariable String testId) {
        return testStatusService.getStatus(testId);
    }
}