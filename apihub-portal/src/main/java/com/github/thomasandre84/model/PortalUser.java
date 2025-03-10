package com.github.thomasandre84.model;

import com.github.thomasandre84.apihub.cryption.CryptionConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortalUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String username;

    @Convert(converter = CryptionConverter.class)
    @Column(length = 8000)
    private String password;
}
