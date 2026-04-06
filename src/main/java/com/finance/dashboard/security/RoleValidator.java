package com.finance.dashboard.security;

import com.finance.dashboard.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleValidator {

    public void checkAdmin(Role role) {
        if (role != Role.ADMIN) {
            throw new RuntimeException("Access Denied");
        }
    }

    public void checkAnalyst(Role role) {
        if (role == Role.VIEWER) {
            throw new RuntimeException("Access Denied");
        }
    }
}