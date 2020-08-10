package com.ahmetserdargeze.migrosassesment.solution1.model.observer;

import com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier.CourierObservableData;

public interface Observer {
    void notify(CourierObservableData data);
}
