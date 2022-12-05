package site.madhavjha.audit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import site.madhavjha.audit.domain.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {
}
