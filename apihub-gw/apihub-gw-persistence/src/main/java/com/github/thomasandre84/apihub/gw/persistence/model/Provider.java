package com.github.thomasandre84.apihub.gw.persistence.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@Entity
public class Provider extends BaseEntity {

    @Column(unique = true)
    private String providerId;

    private URL baseUrl;

    private URL authUrl;

}
