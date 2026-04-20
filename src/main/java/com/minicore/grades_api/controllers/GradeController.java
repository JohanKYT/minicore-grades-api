package com.minicore.grades_api.controllers;

import com.minicore.grades_api.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/calculate")
    public List<Map<String, Object>> calculate(@RequestBody Map<String, String> dates) {
        return gradeService.calculateAllGrades(
                LocalDate.parse(dates.get("p1Start")), LocalDate.parse(dates.get("p1End")),
                LocalDate.parse(dates.get("p2Start")), LocalDate.parse(dates.get("p2End")),
                LocalDate.parse(dates.get("p3Start")), LocalDate.parse(dates.get("p3End"))
        );
    }
}
