package com.photocopy.io.domain.entities;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Comparable<Order>{
  @EqualsAndHashCode.Include private final UUID id;
  private final UUID userId;
  private final UUID printerId;
  private final Object qr; // todo: check how to store the qr
  private Instant printedAt;
  private final Instant createdAt;
  private Instant updatedAt;

  @Override
  public int compareTo(Order o) {
    return this.printedAt.compareTo(o.printedAt);
  }
}
