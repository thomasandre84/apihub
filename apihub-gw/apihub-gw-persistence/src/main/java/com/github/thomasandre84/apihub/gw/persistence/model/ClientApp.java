package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
public class ClientApp extends BaseEntity {

    @ManyToOne
    private Client client;


    @ManyToOne
    private CallbackUrl defaultCallbackUrl;
}
