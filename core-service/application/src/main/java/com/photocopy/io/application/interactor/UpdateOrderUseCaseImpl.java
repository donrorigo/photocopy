package com.photocopy.io.application.interactor;

import com.photocopy.io.application.input.UpdateOrderUseCase;
import com.photocopy.io.application.output.OrderService;
import com.photocopy.io.domain.entities.Order;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

  private final OrderService orderService;

  @Override
  public Order execute(InputValues input) {
    return this.orderService
        .findById(input.getOrderId())
        .map(order -> {
          order.setPrintedAt(input.getPrintedAt());
          order.setPrinterId(input.getPrinterId());
          order.setUpdatedAt(Instant.now());
          return this.orderService.save(order);
        })
        .orElseThrow();
  }
}
