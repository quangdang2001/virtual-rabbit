package com.example.demo;

import com.example.demo.demo1.TransactionType;
import com.example.demo.demo1.TxnRefSequence;
import com.example.demo.demo1.TxnRefSequenceRepo;
import com.example.demo.demo2.TestAsync;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.qpid.server.SystemLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Schedulers;

import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@SpringBootApplication
@RequiredArgsConstructor
@RestController
@Slf4j
public class Demo2Application {
//    private final TxnRefSequenceRepo txnRefSequenceRepo;
//    private final TestAsync async;
//    List<Object> list = new ArrayList<>();
//
//    private Sinks.Many<String> sink;
//
//    private Flux<String> flux;
//
//    @PostConstruct
//    public void  init(){
//        this.sink = Sinks.many().multicast().onBackpressureBuffer();
//        this.flux = this.sink.asFlux().publishOn(Schedulers.boundedElastic());
//        this.flux.publishOn(Schedulers.boundedElastic()).subscribe(s -> {
//            try {
//                process();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
//    @GetMapping("next")
//    public Mono<String> nextVal() {
//
//        return async.simulateEmitData()
////                .subscribeOn(Schedulers.boundedElastic())
//                .map(o -> {
//                        async.processMessage().log("CALL")
//                                .doOnNext(strings -> log.info(Arrays.toString(strings.toCharArray())))
//                                .subscribeOn(Schedulers.boundedElastic())
//                                .subscribe(v -> System.out.println("sub " + v));
////                    sink.tryEmitNext(o);
//                    return "DONE " + Thread.currentThread().getName();
//                });
//    }
//
//    private void process() throws InterruptedException {
//        System.out.println(Thread.currentThread());
//        async.processMessage()
//                .doOnNext(s -> System.out.println("PROCESS" + Thread.currentThread()))
//                .subscribe();
//    }
//
//    public static Consumer<Object> onNext(){
//        return o -> System.out.println("Received : " + o + Thread.currentThread());
//    }
//
//    public static Runnable onComplete(){
//        return () -> System.out.println("Completed "+ Thread.currentThread());
//    }
//    @GetMapping(value = "test")
//    public ResponseEntity<Flux<Integer>> handle() {
//        // handle through which we would push items
////        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
////
////        // handle through which subscribers will receive items
////        Flux<Object> flux = sink.asFlux();
////        flux.subscribe(list::add);
////
/////*        for (int i = 0; i < 1000; i++) {
////            final int j = i;
////            CompletableFuture.runAsync(() -> {
////                sink.tryEmitNext(j);
////            });
////        }*/
////
////        for (int i = 0; i < 1000; i++) {
////            final int j = i;
////            CompletableFuture.runAsync(() -> {
////                sink.emitNext(j, (s, e) -> true);
////            });
////        }
//////        sink.tryEmitComplete();
//
//        return ResponseEntity.ok(Flux.range(1,2).delayElements(Duration.ofSeconds(2)));
//    }
//    @Autowired
//    MessageSender messageSender;
//
//    @Override
//    public void run(String... args) throws Exception {
//        messageSender.sendMessage("hello");
//    }
    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
        try {
            start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    private static final String INITIAL_CONFIGURATION = "test-initial-config.json";
    private static void start() throws Exception {
        final SystemLauncher systemLauncher = new SystemLauncher();
        try {
            systemLauncher.startup(createSystemConfig());
            // performMessagingOperations();
        } finally {

//            systemLauncher.shutdown();
        }
    }

    private static Map<String, Object> createSystemConfig() {
        Map<String, Object> attributes = new HashMap<>();
        URL initialConfig = Demo2Application.class.getClassLoader().getResource(INITIAL_CONFIGURATION);
        attributes.put("type", "Memory");
        attributes.put("initialConfigurationLocation", initialConfig.toExternalForm());
        attributes.put("startupLoggedToSystemOut", true);
        return attributes;
    }

}
