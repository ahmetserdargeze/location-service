package com.ahmetserdargeze.migrosassesment.solution1.service.contract;

import java.util.Date;

public interface CourierService {
    void saveCourierLog(Date logTime,long courierId,double lng,double lat);


}
