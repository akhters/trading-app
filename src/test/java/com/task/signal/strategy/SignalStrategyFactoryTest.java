package com.task.signal.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignalStrategyFactoryTest {

    @Mock
    private SignalStrategy signalStrategyMock1;

    @Mock
    private SignalStrategy signalStrategyMock2;

    private SignalStrategyFactory factory;

    @BeforeEach
    void setup() {
        List<SignalStrategy> strategies = List.of(signalStrategyMock1, signalStrategyMock2);
        when(signalStrategyMock1.getSignal()).thenReturn(100);
        when(signalStrategyMock2.getSignal()).thenReturn(200);
        factory = new SignalStrategyFactory(strategies);
    }

    @Test
    void shouldGetStrategy() {
        assertThat(factory.getStrategy(100)).isEqualTo(signalStrategyMock1);

        assertThat(factory.getStrategy(200)).isEqualTo(signalStrategyMock2);

        assertThat(factory.getStrategy(300)).isInstanceOf(DefaultSignalStrategy.class);
    }
}
