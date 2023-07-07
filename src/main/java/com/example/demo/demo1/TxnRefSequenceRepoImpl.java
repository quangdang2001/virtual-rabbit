package com.example.demo.demo1;


import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class TxnRefSequenceRepoImpl implements TxnRefSequenceRepo {
    private ReactiveMongoTemplate mongoTemplate;
    private Repo repo;

    @Override
    public Mono<TxnRefSequence> getNextValue(TransactionType transactionType) {
        Update updateDefinition = new Update();
        updateDefinition.inc("seqValue");

        return findAndModify(transactionType, updateDefinition);
    }

    @Override
    public Mono<TxnRefSequence> resetSequenceValue(TransactionType transactionType) {
        Update updateDefinition = new Update();
        updateDefinition.set("seqValue", 0);

        return findAndModify(transactionType, updateDefinition);
    }

    private Mono<TxnRefSequence> findAndModify(TransactionType transactionType, Update update) {
        Query query = new Query().addCriteria(Criteria.where("id").is(transactionType));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        return mongoTemplate.findAndModify(query, update, options, TxnRefSequence.class);
    }


    @Override
    public Mono<TxnRefSequence> getNextValue2(TransactionType transactionType) {

        return repo.findById(TransactionType.FTX)
                .map(txnRefSequence -> {
                    txnRefSequence.setSeqValue(txnRefSequence.getSeqValue() + 1);
                    return txnRefSequence;
                })
                .flatMap(txnRefSequence -> repo.save(txnRefSequence));
    }


}
