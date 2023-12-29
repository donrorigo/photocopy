package com.photocopy.io.core.application.input;

import com.photocopy.io.global.tools.application.UseCase;
import java.util.UUID;

public interface GenerateQrUseCase extends UseCase<UUID, String > {
  // 0. pending to generate the QR
  // 1. generate random UUID
  // 2. store it in the QR
  // 3. upload it to S3
  // 4. store the S3 URL into the order domain
}
