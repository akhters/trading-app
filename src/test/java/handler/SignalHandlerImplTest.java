package handler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.task.signal.handler.SignalHandlerImpl;
import com.task.signal.strategy.DefaultSignalStrategy;
import com.task.signal.strategy.SignalStrategyFactory;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SignalHandlerImplTest {

  @Mock private SignalStrategyFactory factory;

  @InjectMocks private SignalHandlerImpl signalHandler;

  @Test
  void shouldHandleSignal() {
    when(factory.getStrategy(anyInt())).thenReturn(new DefaultSignalStrategy());

    signalHandler.handleSignal(1);

    verify(factory).getStrategy(1);
  }
}
