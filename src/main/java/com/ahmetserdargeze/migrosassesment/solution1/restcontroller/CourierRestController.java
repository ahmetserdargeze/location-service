package com.ahmetserdargeze.migrosassesment.solution1.restcontroller;

import com.ahmetserdargeze.migrosassesment.solution1.model.input.CreateCourierLogInput;
import com.ahmetserdargeze.migrosassesment.solution1.model.response.BaseResponse;
import com.ahmetserdargeze.migrosassesment.solution1.service.contract.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CourierRestController extends BaseController {

    @Autowired
    CourierService courierService;

    @PostMapping("/saveCourierLog")
    @ResponseBody
    BaseResponse all(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date logTime, @RequestParam long courierId, @RequestParam double lng, @RequestParam double lat) {
        //logTime parameter must be yyyy-mm-dd hh:mm:ss format such as 2020-08-16 23:17:47
        try {
            CreateCourierLogInput createCourierLogInput = new CreateCourierLogInput.Builder()
                    .logTime(logTime)
                    .courierId(courierId)
                    .lng(lng)
                    .lat(lat)
                    .build();
            return courierService.saveCourierLog(createCourierLogInput);
        } catch (Exception e) {
            logger.error("Error occured from inserting courier log");
            return new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Courier log insert with error", false);
        }
    }

    @GetMapping("/getTotalTravelDistance")
    @ResponseBody
    BaseResponse all(@RequestParam long courierId) {
        return courierService.getTotalTravelDistance(courierId);
    }

}
