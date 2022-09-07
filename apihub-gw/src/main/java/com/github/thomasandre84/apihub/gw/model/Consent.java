package com.github.thomasandre84.apihub.gw.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
public class Consent {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
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

    @OneToOne
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
