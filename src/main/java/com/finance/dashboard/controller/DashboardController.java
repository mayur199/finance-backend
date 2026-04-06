package com.finance.dashboard.controller;

import com.finance.dashboard.entity.Role;
import com.finance.dashboard.security.RoleValidator;
import com.finance.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;
    private final RoleValidator validator;

    @GetMapping("/summary")
    public Map<String, Double> getSummary(@RequestParam Role role) {
        validator.checkAnalyst(role);
        return service.getSummary();
    }
}