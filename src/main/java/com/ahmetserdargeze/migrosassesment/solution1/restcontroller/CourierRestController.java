package com.ahmetserdargeze.migrosassesment.solution1.restcontroller;

import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CourierRestController {

//    Date logTime,long courierId,double lng,double lat

    @Autowired
    CourierService courierService;

    @PostMapping("/saveCourierLog")
    @ResponseBody
    BaseResponse all(@RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date logTime, @RequestParam long courierId , @RequestParam double lng , @RequestParam double lat ) {
        //logTime parameter must be yyyy-mm-dd hh:mm:ss format
        return courierService.saveCourierLog(logTime,courierId,lng,lat);
    }

    @GetMapping("/getTotalTravelDistance")
    @ResponseBody
    BaseResponse all(@RequestParam long courierId) {
        return courierService.getTotalTravelDistance(courierId);
    }

}
