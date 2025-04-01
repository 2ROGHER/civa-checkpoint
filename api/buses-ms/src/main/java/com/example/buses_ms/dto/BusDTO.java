package com.example.buses_ms.dto;

import java.util.UUID;

public record BusDTO(
        UUID id,
        String name,
        String description
) {
}
