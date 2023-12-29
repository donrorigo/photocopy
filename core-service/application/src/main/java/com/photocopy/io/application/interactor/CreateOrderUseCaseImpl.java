package com.photocopy.io.application.interactor;

import com.photocopy.io.application.input.CreateOrderUseCase;
import com.photocopy.io.application.output.OrderService;
import com.photocopy.io.domain.entities.Order;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

  private final OrderService orderService;

  @Override
  public Order execute(final InputValues input) {
    return this.orderService.save(Order.builder()
        .id(UUID.randomUUID())
        .userId(input.getUserId())
        .printerId(input.getPrinterId())
        .printedAt(input.getPrintedAt())
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build());
  }
}
