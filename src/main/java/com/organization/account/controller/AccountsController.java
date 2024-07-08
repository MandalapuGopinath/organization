package com.organization.account.controller;

import com.organization.account.dto.CustomerType;
import com.organization.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/generate")
    public ResponseEntity<Map<String, Map<CustomerType, Map<String, Object>>>> generateReport(
            @RequestParam Date fromDate,
            @RequestParam Date toDate,
            @RequestParam String type) {

        Map<String, Map<CustomerType, Map<String, Object>>> reportData = accountService.generateReport(fromDate, toDate, type);
        return ResponseEntity.ok(reportData);
    }
}



