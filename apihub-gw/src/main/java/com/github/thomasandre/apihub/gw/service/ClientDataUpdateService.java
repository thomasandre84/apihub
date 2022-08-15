package com.github.thomasandre.apihub.gw.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ClientDataUpdateService {

    @Incoming("client-updates")
    public CompletionStage<Void> consume(Message<Double> price) {
        return price.ack();
    }
}
