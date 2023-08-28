package com.task.signal.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Factory class of Signal strategies. Maintains map of signal code and corresponding strategy
 * implementation for faster lookup
 */
@Service
public class SignalStrategyFactory {

  private final Map<Integer, SignalStrategy> strategies = new HashMap<>();

  @Autowired
  public SignalStrategyFactory(List<SignalStrategy> strategyList) {
    strategyList.forEach(strategy -> strategies.put(strategy.getSignal(), strategy));
  }

  public SignalStrategy getStrategy(int signal) {
    return strategies.getOrDefault(signal, new DefaultSignalStrategy());
  }
}
