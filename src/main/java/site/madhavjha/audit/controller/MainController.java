package site.madhavjha.audit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.madhavjha.audit.domain.Transaction;
import site.madhavjha.audit.service.AuditService;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/save")
    public Transaction save(@RequestBody Transaction transaction) {
        log.info("Saving transaction");
        return auditService.saveTransaction(transaction);
    }

    @GetMapping("/last-update/{id}")
    public Transaction lastUpdatedVersion(@PathVariable String id) {
        return auditService.getLastUpdatedVersion(id);
    }

    @GetMapping("/changes/{id}")
    public Object changes(@PathVariable String id) {
        return auditService.getChanges(id);
    }

    @GetMapping("/changes-pretty/{id}")
    public Object changesPretty(@PathVariable String id) {
        return auditService.getChanges(id).prettyPrint();
    }
}
