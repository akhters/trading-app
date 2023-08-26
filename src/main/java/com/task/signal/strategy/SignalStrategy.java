package com.task.signal.strategy;

import com.task.library.Algo;

/**
 * The SignalStrategy interface represents a strategy for handling different signals
 * with varying algorithms. Implementations of this interface encapsulate the
 * specific algorithm to be executed for each signal.
 */
public interface SignalStrategy {

    /**
     * Executes the algorithm associated with this signal strategy.
     * @param algo
     */
    void handle(Algo algo);

    /**
     * Gets the unique identifier for the signal that this strategy handles.
     *
     * @return The signal identifier.
     */
    int getSignal();
}
