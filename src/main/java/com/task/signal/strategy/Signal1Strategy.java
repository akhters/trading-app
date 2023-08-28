package com.task.signal.strategy;

import org.springframework.stereotype.Service;

import com.task.library.Algo;

@Service
public class Signal1Strategy implements SignalStrategy {

  private final int SIGNAL = 1;

  @Override
  public void handle(Algo algo) {
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
  }

  @Override
  public int getSignal() {
    return SIGNAL;
  }
}
