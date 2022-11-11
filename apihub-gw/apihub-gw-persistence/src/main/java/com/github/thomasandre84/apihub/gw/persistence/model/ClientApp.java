package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class ClientApp extends BaseEntity {

    @ManyToOne
    private Client client;


    @ManyToOne
    private CallbackUrl defaultCallbackUrl;
}
