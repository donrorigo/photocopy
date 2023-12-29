package com.photocopy.io.printer.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
  private final UUID id;
  private final UUID userId;
  private final BigDecimal pricing;
  private final Boolean isBlackAndWhite;
  private Boolean isAlreadyPaid;
  private final String pdfReference;
}
