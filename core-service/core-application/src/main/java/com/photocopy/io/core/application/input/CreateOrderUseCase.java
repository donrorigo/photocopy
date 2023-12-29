package com.photocopy.io.core.application.input;

import com.photocopy.io.core.application.input.CreateOrderUseCase.InputValues;
import com.photocopy.io.core.domain.entities.Order;
import com.photocopy.io.global.tools.application.UseCase;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

public interface CreateOrderUseCase extends UseCase<InputValues, Order> {

  @Data
  @Builder
  class InputValues {
    private final UUID userId;
    private final UUID printerId;
    private final Object pdf; // todo: check how to store the PDF
    private final Instant printedAt;
  }
}
