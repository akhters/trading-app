package com.task.signal.strategy;

import com.task.library.Algo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultSignalStrategy implements SignalStrategy {

  @Override
  public void handle(Algo algo) {
    log.info("Executing Default Strategy");
    algo.cancelTrades();
  }

  @Override
  public int getSignal() {
    return -1;
  }
}
