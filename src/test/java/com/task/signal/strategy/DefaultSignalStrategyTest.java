package com.task.signal.strategy;

import com.task.library.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DefaultSignalStrategyTest {

    private SignalStrategy signalStrategy = new DefaultSignalStrategy();

    @Spy
    private Algo algo = new Algo();

    @Test
    void shouldHandleSignal() {

        signalStrategy.handle(algo);

        verify(algo).cancelTrades();
    }

    @Test
    void shouldReturnSignalOne() {
        assertThat(signalStrategy.getSignal()).isEqualTo(-1);
    }

}
