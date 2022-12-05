package site.madhavjha.audit.service;

import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.madhavjha.audit.domain.Transaction;
import site.madhavjha.audit.repository.TransactionRepository;

@Service
public class AuditService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private Javers javers;

    public Transaction saveTransaction(Transaction trx) {
        var savedTrx = repository.save(trx);
        javers.commit("AuditService", savedTrx);
        return savedTrx;
    }

    public Transaction getLastUpdatedVersion(String id) {
        var shadows = javers.findShadows(QueryBuilder.byInstanceId(id, Transaction.class).withScopeDeepPlus().build());

        if (shadows.isEmpty()) {
            return new Transaction();
        }

        if (shadows.size() > 1) {
            return (Transaction) shadows.get(shadows.size() - 2).get();
        }

        return (Transaction) shadows.get(0).get();
    }

    public Changes getChanges(String id) {
        return javers.findChanges(QueryBuilder.byInstanceId(id, Transaction.class).withChildValueObjects().build());
    }
}
