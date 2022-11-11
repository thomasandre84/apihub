package com.github.thomasandre84.apihub.gw.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.UUID;

@Data
@Entity
public class CallbackUrl extends BaseEntity {

    private URI url;
}
