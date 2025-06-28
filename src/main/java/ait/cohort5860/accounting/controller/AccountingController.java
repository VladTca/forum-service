package ait.cohort5860.accounting.controller;

import ait.cohort5860.accounting.service.AccountingService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountingController {

    private final AccountingService accountingService;




}
