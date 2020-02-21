package com.plappgardenerservice.controllers;

import com.plappgardenerservice.entities.ScheduleAction;
import com.plappgardenerservice.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class DataServiceController {

    @Autowired
    ScheduleService scheduleService;

    /* This method is invoked whenever a user requests
     * the insertion of a new schedule (e.g. water, prune, ...)
     */
    @PutMapping("/add_schedule")
    ScheduleAction addSchedule(@RequestParam long plantID, @RequestParam Date date, @RequestParam String action, @RequestParam int periodicity) {
        System.out.println("INVOKED");
        System.out.println(plantID);
        System.out.println(action);
        System.out.println(date);
        System.out.println(periodicity);
        ScheduleAction newScheduleAction = scheduleService.createSchedule(plantID, date, action, periodicity);
        return newScheduleAction;
    }

    //TODO chiamata per la diagnosi

}
