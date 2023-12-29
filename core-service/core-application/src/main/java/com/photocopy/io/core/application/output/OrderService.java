package com.photocopy.io.core.application.output;

import com.photocopy.io.core.domain.entities.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {

  Order save(final Order order);

  Optional<Order> findById(final UUID id);
}
