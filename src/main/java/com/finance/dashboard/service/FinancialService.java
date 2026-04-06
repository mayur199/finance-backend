package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialService {

    private final FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public FinancialRecord update(Long id, FinancialRecord record) {
        FinancialRecord existing = repo.findById(id).orElseThrow();
        existing.setAmount(record.getAmount());
        existing.setType(record.getType());
        existing.setCategory(record.getCategory());
        existing.setDate(record.getDate());
        existing.setNotes(record.getNotes());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<FinancialRecord> filter(String type, String category) {
        if (type != null && category != null) {
            return repo.findByTypeAndCategory(type, category);
        } else if (type != null) {
            return repo.findByType(type);
        } else if (category != null) {
            return repo.findByCategory(category);
        }
        return repo.findAll();
    }
}