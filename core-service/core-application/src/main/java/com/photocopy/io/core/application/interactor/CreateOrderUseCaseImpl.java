package com.photocopy.io.core.application.interactor;

import com.photocopy.io.core.application.input.CreateOrderUseCase;
import com.photocopy.io.core.application.input.GenerateQrUseCase;
import com.photocopy.io.core.application.output.FileService;
import com.photocopy.io.core.application.output.OrderService;
import com.photocopy.io.core.domain.entities.Order;
import java.time.Instant;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

  private final OrderService orderService;
  private final FileService fileService;
  private final GenerateQrUseCase generateQrUseCase;

  @Override
  public Order execute(final InputValues input) {

    return this.orderService.save(
        Order.builder()
            .id(UUID.randomUUID())
            .userId(input.getUserId())
            .printerId(input.getPrinterId())
            .printedAt(input.getPrintedAt())
            .pdfReference(this.fileService.storeFile(input.getPdf()))
            .qrReference(this.generateQrUseCase.execute(UUID.randomUUID()))
            .createdAt(Instant.now())
            .updatedAt(Instant.now())
            .build());
  }
}
