package com.photocopy.io.application.output;

import com.photocopy.io.domain.entities.Order;

public interface OrderService {

  Order save(final Order order);

}
