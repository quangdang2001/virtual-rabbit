package com.example.demo.demo1;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@ToString
public class TxnRefSequence {
    @Id
    private TransactionType id;
    private int seqValue;
}
