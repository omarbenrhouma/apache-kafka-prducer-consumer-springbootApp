package org.sid.demospringcloudstreamskafka.services;

import org.sid.demospringcloudstreamskafka.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.springframework.integration.graph.LinkNode.Type.input;

@Service

public class PageEventService {
    @Bean
    public Consumer <PageEvent> pageEventConsumer(){
        return (input)->{
            System.out.println("**********************");
            System.out.println(input.toString());
            System.out.println("**********************");
        };
    };
    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return ()-> new PageEvent(Math.random()>0.5?"P1":"P2",
                Math.random()>0.5?"U1":"U2",
                new Date(),
                new Random().nextInt(9000));
    }
    @Bean
    public Function<PageEvent,PageEvent>eventPageEventFunction(){
        return (input)->{
            input.setName("l:"+input.getName().length());
            input.setUser("UUUUUU");
            return input;
        };
    }
}
