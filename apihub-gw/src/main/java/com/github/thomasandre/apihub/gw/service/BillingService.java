package com.github.thomasandre.apihub.gw.service;

import com.github.thomasandre.apihub.BillingInfo;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class BillingService {

    @Channel("billing")
    Emitter<BillingInfo> emitter;

    public void sendBillingInfo(BillingInfo billingInfo) {
        log.info("Sending BillingInfo for Client {} to Kafka", billingInfo.getClientId());
        emitter.send(billingInfo);
    }


}
