package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import java.net.URI;


@Getter
@Setter
@Entity
public class CallbackUrl extends BaseEntity {

    private URI url;
}
