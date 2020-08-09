package com.ahmetserdargeze.migrosassesment.solution1.restcontroller;

import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.CourierLogSaveResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class CourierRestController {

//    Date logTime,long courierId,double lng,double lat

    @Autowired
    CourierService courierService;

    @PostMapping("/saveCourierLog")
    @ResponseBody
    BaseResponse all(@RequestParam Timestamp logTime, @RequestParam long courierId , @RequestParam double lng , @RequestParam double lat ) {
        //logTime parameter must be yyyy-mm-dd hh:mm:ss format

        System.out.println("assdasdasd");
        return courierService.saveCourierLog(logTime,courierId,lng,lat);
    }

}
