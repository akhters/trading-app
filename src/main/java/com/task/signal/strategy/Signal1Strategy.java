package com.task.signal.strategy;

import org.springframework.stereotype.Service;

import com.task.library.Algo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Signal1Strategy implements SignalStrategy {

  private final int SIGNAL = 1;

  @Override
  public void handle(Algo algo) {
    log.info("Executing Signal Strategy 1");
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
