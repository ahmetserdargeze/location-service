package com.ahmetserdargeze.migrosassesment.solution1.model.observer;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
