package com.finance.dashboard.controller;

import com.finance.dashboard.dto.FinancialRecordDTO;
import com.finance.dashboard.entity.*;
import com.finance.dashboard.security.RoleValidator;
import com.finance.dashboard.service.FinancialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class FinancialController {

    private final FinancialService service;
    private final RoleValidator validator;

    @PostMapping
    public FinancialRecord create(
            @Valid @RequestBody FinancialRecordDTO dto,
            @RequestParam Role role) {

        validator.checkAdmin(role);

        FinancialRecord record = new FinancialRecord();
        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setNotes(dto.getNotes());

        return service.create(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll(@RequestParam Role role) {
        validator.checkAnalyst(role);
        return service.getAll();
    }

    @PutMapping("/{id}")
    public FinancialRecord update(
            @PathVariable Long id,
            @Valid @RequestBody FinancialRecordDTO dto,
            @RequestParam Role role) {

        validator.checkAdmin(role);

        FinancialRecord record = new FinancialRecord();
        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setNotes(dto.getNotes());

        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestParam Role role) {

        validator.checkAdmin(role);
        service.delete(id);
    }

    @GetMapping("/filter")
    public List<FinancialRecord> filter(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam Role role) {

        validator.checkAnalyst(role);
        return service.filter(type, category);
    }
}