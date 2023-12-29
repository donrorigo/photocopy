package com.photocopy.io.global.tools.application;

public interface UseCase<I, O> {
  O execute(I input);
}
