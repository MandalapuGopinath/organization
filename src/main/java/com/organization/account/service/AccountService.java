package com.organization.account.service;

import com.organization.account.dto.CustomerType;
import com.organization.account.repository.TcareAccountRepository;
import com.organization.account.repository.TcareCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    @Autowired
    private TcareAccountRepository accountRepository;

    @Autowired
    private TcareCustomerRepository customerRepository;

    public Map<String, Map<CustomerType, Map<String, Object>>> generateReport(Date fromDate, Date toDate, String type) {
        Map<String, Map<CustomerType, Map<String, Object>>> reportData = new LinkedHashMap<>();

        // Determine the date range based on type
        if ("Monthly".equalsIgnoreCase(type) || "Y".equalsIgnoreCase(type)) {
            // For Monthly or Y type, fromDate and toDate are already set
        } else {
            // For specific month name (e.g., "January", "February", etc.), calculate weekly data
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fromDate);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            calendar.set(year, month, 1, 0, 0, 0);
            fromDate = calendar.getTime();

            calendar.set(year, month, calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            toDate = calendar.getTime();
        }

        // Fetch data from repositories
        Long registeredUsers = accountRepository.countRegisteredUsers(Arrays.asList(20L, 30L, 40L, 51L, 52L), fromDate, toDate);
        Long activatedCompanies = customerRepository.countActivatedCompanies(fromDate, toDate);

        // Prepare data maps for different customer types
        Map<CustomerType, Map<String, Object>> dataMap = new LinkedHashMap<>();
        dataMap.put(CustomerType.SME, createBusinessData(registeredUsers, activatedCompanies));
        dataMap.put(CustomerType.GOVERNMENT, createBusinessData(registeredUsers, activatedCompanies));
        dataMap.put(CustomerType.ENTERPRISE, createBusinessData(registeredUsers, activatedCompanies));

        // Calculate grand total
        long grandTotalRegisteredUsers = dataMap.values().stream()
                .mapToLong(map -> (Long) map.get("registeredUser"))
                .sum();
        long grandTotalActivatedCompanies = dataMap.values().stream()
                .mapToLong(map -> (Long) map.get("activatedCompanies"))
                .sum();

        Map<String, Object> grandTotalMap = new HashMap<>();
        grandTotalMap.put("registeredUser", grandTotalRegisteredUsers);
        grandTotalMap.put("activatedCompanies", grandTotalActivatedCompanies);

        dataMap.put(CustomerType.GRANDTOTAL, grandTotalMap);

        // Add to reportData with the appropriate key (month name or week number)
        reportData.put(getReportKey(fromDate), dataMap);

        return reportData;
    }

    // Helper method to create business data map
    private Map<String, Object> createBusinessData(Long registeredUsers, Long activatedCompanies) {
        Map<String, Object> data = new HashMap<>();
        data.put("registeredUser", registeredUsers);
        data.put("activatedCompanies", activatedCompanies);
        return data;
    }

    // Helper method to get report key (month name or week number)
    private String getReportKey(Date fromDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        int month = calendar.get(Calendar.MONTH);
        return getMonthName(month);
    }

    // Helper method to get month name based on month number
    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}