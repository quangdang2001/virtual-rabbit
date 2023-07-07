package com.example.demo.demo1;


import reactor.core.publisher.Mono;

public interface TxnRefSequenceRepo {
    Mono<TxnRefSequence> getNextValue(TransactionType transactionType);
    Mono<TxnRefSequence> resetSequenceValue(TransactionType transactionType);

    Mono<TxnRefSequence> getNextValue2(TransactionType transactionType);

}
