package com.photocopy.io.application.input;

import com.photocopy.io.application.input.UpdateOrderUseCase.InputValues;
import com.photocopy.io.domain.entities.Order;
import com.photocopy.io.global.tools.application.UseCase;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

public interface UpdateOrderUseCase extends UseCase<InputValues, Order> {

  @Data
  @Builder
  class InputValues {
    private final UUID orderId;
    private final UUID printerId;
    private final Instant printedAt;
  }

}
