package com.github.thomasandre84.apihub.gw.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClientApp extends BaseEntity {

    @ManyToOne
    private Client client;


    @ManyToOne
    private CallbackUrl callbackUrl;
}
