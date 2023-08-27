package com.task.signal.strategy;

import com.task.library.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Signal3StrategyTest {

    private SignalStrategy signalStrategy = new Signal3Strategy();

    @Spy
    private Algo algo = new Algo();

    @Test
    void shouldHandleSignal() {

        signalStrategy.handle(algo);

        verify(algo).setAlgoParam(eq(1), eq(90));
        verify(algo).setAlgoParam(eq(2), eq(15));
        verify(algo).performCalc();
        verify(algo).submitToMarket();
    }

    @Test
    void shouldReturnSignalOne() {
        assertThat(signalStrategy.getSignal()).isEqualTo(3);
    }

}
