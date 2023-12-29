package com.photocopy.io.back4front.domain.entities;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
  private final UUID id;
  private final UUID printerId;
  private final UUID userId;
}
