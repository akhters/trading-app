package com.task.signal.strategy;

import org.springframework.stereotype.Service;

import com.task.library.Algo;

@Service
public class Signal3Strategy implements SignalStrategy {

  private final int SIGNAL = 3;

  @Override
  public void handle(Algo algo) {
    algo.setAlgoParam(1, 90);
    algo.setAlgoParam(2, 15);
    algo.performCalc();
    algo.submitToMarket();
  }

  @Override
  public int getSignal() {
    return SIGNAL;
  }
}
