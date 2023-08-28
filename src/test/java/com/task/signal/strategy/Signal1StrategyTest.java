package com.task.signal.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.task.library.Algo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Signal1StrategyTest {

  private SignalStrategy signalStrategy = new Signal1Strategy();

  @Spy private Algo algo = new Algo();

  @Test
  void shouldHandleSignal() {

    signalStrategy.handle(algo);

    verify(algo).setUp();
    verify(algo).setAlgoParam(eq(1), eq(60));
    verify(algo).performCalc();
    verify(algo).submitToMarket();
  }

  @Test
  void shouldReturnSignalOne() {
    assertThat(signalStrategy.getSignal()).isEqualTo(1);
  }
}
