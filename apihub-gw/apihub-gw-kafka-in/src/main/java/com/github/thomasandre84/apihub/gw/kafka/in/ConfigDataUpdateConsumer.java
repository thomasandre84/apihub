package com.github.thomasandre84.apihub.gw.kafka.in;

import com.github.thomasandre84.apihub.gw.core.service.ConfigUpdateService;
import lombok.RequiredArgsConstructor;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@RequiredArgsConstructor
@ApplicationScoped
public class ConfigDataUpdateConsumer {

    private final ConfigUpdateService updateService;

    @Incoming("client-updates")
    public CompletionStage<Void> consume(Message<Double> price) {
        return price.ack();
    }
}
