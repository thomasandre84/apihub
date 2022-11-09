package com.github.thomasandre84.apihub.gw.api.resource.v1.dto;

import java.util.UUID;

public record ConsentResponseDto(UUID consentId, String providerId, UUID userId, String scope, String status) {
}
