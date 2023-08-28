package com.task.signal.handler;

import org.springframework.stereotype.Service;

import com.task.library.Algo;
import com.task.library.SignalHandler;
import com.task.signal.strategy.SignalStrategyFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignalHandlerImpl implements SignalHandler {

  private final SignalStrategyFactory signalFactory;

  @Override
  public void handleSignal(int signal) {
    signalFactory.getStrategy(signal).handle(new Algo());
  }
}
