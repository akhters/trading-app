package com.task.signal.strategy;

import com.task.library.Algo;
import org.springframework.stereotype.Service;

@Service
public class Signal2Strategy implements SignalStrategy {

    private final int SIGNAL = 2;

    @Override
    public void handle(Algo algo) {
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
    }

    @Override
    public int getSignal() {
        return SIGNAL;
    }
}
