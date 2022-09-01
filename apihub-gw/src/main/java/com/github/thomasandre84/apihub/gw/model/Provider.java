package com.github.thomasandre84.apihub.gw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity
public class Provider {

    @Id
    private String id;

    private URL baseUrl;

}
