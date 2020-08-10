package com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier;

import com.ahmetserdargeze.migrosassesment.solution1.model.observer.Observable;
import com.ahmetserdargeze.migrosassesment.solution1.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CourierObservable implements Observable {
    private List<Observer> observerList = new ArrayList<>();

    private CourierObservableData courierObservableData;

    public CourierObservableData getObservableData() {
        return courierObservableData;
    }

    public void setObservableData(CourierObservableData courierObservableData) {
        this.courierObservableData = courierObservableData;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.notify(courierObservableData);
        }
    }


}
