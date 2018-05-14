package com.github.guide.core;

/**
 * @author Yang Lifan
 */
public interface SelectStrategy<T> {
    void addMatchResult(MatchResult<T> matchResult);

    void addCandidate(T candidate);

    T getWinner();
}