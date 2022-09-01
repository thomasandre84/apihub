package com.github.thomasandre84.apihub.gw.model;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
public class Consent {

    @Id
    private UUID id;

    private String scope;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client userId;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider providerId;

    private OffsetDateTime created;

    private OffsetDateTime updated;

    private ConsentStatus status;

    @PrePersist
    void create() {
        created = OffsetDateTime.now();
        updated = OffsetDateTime.now();
        status = ConsentStatus.CREATED;
    }

    @PreUpdate
    void update() {
        updated = OffsetDateTime.now();
    }
}
