package com.github.thomasandre84.apihub.gw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Client {

    @Id
    private UUID id;
}
