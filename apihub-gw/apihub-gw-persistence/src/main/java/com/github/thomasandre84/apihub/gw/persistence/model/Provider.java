package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.net.URL;

@Data
@Entity
public class Provider extends BaseEntity {

    @Column(unique = true)
    private String providerId;

    private URL baseUrl;

    private URL authUrl;

}
