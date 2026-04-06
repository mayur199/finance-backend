package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repo;

    public Map<String, Double> getSummary() {
        List<FinancialRecord> list = repo.findAll();

        double income = list.stream()
                .filter(r -> "INCOME".equals(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double expense = list.stream()
                .filter(r -> "EXPENSE".equals(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Map<String, Double> map = new HashMap<>();
        map.put("totalIncome", income);
        map.put("totalExpense", expense);
        map.put("netBalance", income - expense);

        return map;
    }
}