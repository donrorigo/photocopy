package com.photocopy.io.core.application.input;

import com.photocopy.io.global.tools.application.UseCase;

public interface DeleteQrUseCase extends UseCase<String, Boolean> {

  // 1. Search the QR image in S3
  // 2. If it does not exist return TRUE
  // 3. If it does not throw any error return TRUE
  // 4. If it was not possible return FALSE
}
