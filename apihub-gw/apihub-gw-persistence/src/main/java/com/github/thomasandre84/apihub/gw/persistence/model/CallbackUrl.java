package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.net.URI;
import java.util.UUID;

@Data
@Entity
public class CallbackUrl extends BaseEntity {

    private URI url;
}
