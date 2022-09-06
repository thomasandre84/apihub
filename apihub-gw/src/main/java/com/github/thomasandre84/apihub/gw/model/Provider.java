package com.github.thomasandre84.apihub.gw.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Data
@Entity
public class Provider {

    @Id
    private String id;

    private URL baseUrl;

}
