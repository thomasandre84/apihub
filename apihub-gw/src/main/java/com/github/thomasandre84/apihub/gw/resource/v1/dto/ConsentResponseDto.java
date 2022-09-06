package com.github.thomasandre84.apihub.gw.resource.v1.dto;

import java.util.UUID;

public record ConsentResponseDto(UUID referenceID, String providerId, UUID userId) {
}
