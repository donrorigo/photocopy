package com.photocopy.io.core.application.interactor;

import com.photocopy.io.core.application.input.DeleteQrUseCase;
import com.photocopy.io.core.application.input.GenerateQrUseCase;
import com.photocopy.io.core.application.input.UpdateOrderUseCase;
import com.photocopy.io.core.application.output.OrderService;
import com.photocopy.io.core.domain.entities.Order;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

  private final OrderService orderService;
  private final GenerateQrUseCase generateQrUseCase;
  private final DeleteQrUseCase deleteQrUseCase;

  @Override
  public Order execute(InputValues input) {
    return this.orderService
        .findById(input.getOrderId())
        .map(
            order -> {

              if (this.deleteQrUseCase.execute(order.getQrReference()).equals(Boolean.FALSE)){
                throw new RuntimeException("There was an error trying to update the QR code");
              }

              order.setPrintedAt(input.getPrintedAt());
              order.setPrinterId(input.getPrinterId());
              order.setQrReference(this.generateQrUseCase.execute(UUID.randomUUID()));
              order.setUpdatedAt(Instant.now());
              return this.orderService.save(order);
            })
        .orElseThrow();
  }
}
