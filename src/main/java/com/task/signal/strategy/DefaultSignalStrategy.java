package com.task.signal.strategy;

import com.task.library.Algo;

public class DefaultSignalStrategy implements SignalStrategy {

    @Override
    public void handle(Algo algo) {
        algo.cancelTrades();
    }

    @Override
    public int getSignal() {
        return -1;
    }
}
