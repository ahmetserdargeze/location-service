package com.ahmetserdargeze.migrosassesment.solution1.model.observer.courier;

import com.ahmetserdargeze.migrosassesment.solution1.model.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MobileObserver implements Observer {
    Logger logger = LoggerFactory.getLogger(MobileObserver.class);

    @Override
    public void notify(CourierObservableData data) {
        if (data.getNearestMigrosDistance() < 100) {
            StringBuilder builder = new StringBuilder();
            builder.append("CourierId:");
            builder.append(data.getCourierId());
            builder.append(" Store Name:");
            builder.append(data.getNearestMigrosName());
            builder.append(" Distance:");
            builder.append(data.getNearestMigrosDistance());
            logger.info(builder.toString());
        }

    }
}
