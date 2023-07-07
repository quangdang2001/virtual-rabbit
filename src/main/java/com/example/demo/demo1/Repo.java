package com.example.demo.demo1;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repo extends ReactiveMongoRepository<TxnRefSequence, TransactionType> {
}
