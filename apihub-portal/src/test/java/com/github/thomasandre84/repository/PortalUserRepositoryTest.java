package com.github.thomasandre84.repository;

import com.github.thomasandre84.model.PortalUser;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class PortalUserRepositoryTest {

    @Inject
    PortalUserRepository portalUserRepository;

    @Inject
    UserTransaction userTransaction;

    @Disabled
    @Test
    void testCrud() throws Exception {
        // arrange
        UUID id = UUID.randomUUID();
        String userName = "test";
        String password = "password";
        PortalUser user = new PortalUser(id, userName, password);

        // act
        userTransaction.begin();
        portalUserRepository.persist(user);
        userTransaction.commit();

        // assert
        PortalUser saved = portalUserRepository.findById(id);
        assertEquals(user, saved);

    }
}