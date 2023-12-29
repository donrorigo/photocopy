package com.photocopy.io.core.domain.entities;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Comparable<Order> {
  @EqualsAndHashCode.Include private final UUID id;
  private final UUID userId;
  private UUID printerId;
  private String qrReference;
  private String pdfReference;
  private Instant printedAt;
  private final Instant createdAt;
  private Instant updatedAt;

  @Override
  public int compareTo(Order o) {
    return this.printedAt.compareTo(o.printedAt);
  }
}
