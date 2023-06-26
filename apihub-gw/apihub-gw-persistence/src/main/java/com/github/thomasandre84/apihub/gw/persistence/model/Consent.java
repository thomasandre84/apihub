package com.github.thomasandre84.apihub.gw.persistence.model;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentStatus;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class Consent extends BaseEntity {

    private String scope;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "client_app_id")
    private ClientApp clientApp;

    private String userId;

    private OffsetDateTime created;

    private OffsetDateTime updated;

    @Enumerated(EnumType.STRING)
    private ConsentStatus status;

    @OneToOne(optional = true)
    private ProviderToken providerToken;

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
