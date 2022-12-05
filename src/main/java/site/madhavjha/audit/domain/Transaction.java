package site.madhavjha.audit.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String trxId;
    private Product product;
}
