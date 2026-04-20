package com.minicore.grades_api.services;

import com.minicore.grades_api.models.Grade;
import com.minicore.grades_api.models.Student;
import com.minicore.grades_api.repositories.GradeRepository;
import com.minicore.grades_api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Map<String, Object>> calculateAllGrades(
            LocalDate p1Start, LocalDate p1End,
            LocalDate p2Start, LocalDate p2End,
            LocalDate p3Start, LocalDate p3End) {

        List<Student> students = studentRepository.findAll();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Student s : students) {
            List<Grade> allGrades = gradeRepository.findByStudentId(s.getId());

            double avgP1 = calculateAverage(allGrades, p1Start, p1End);
            double avgP2 = calculateAverage(allGrades, p2Start, p2End);
            double avgP3 = calculateAverage(allGrades, p3Start, p3End);

            Map<String, Object> row = new HashMap<>();
            row.put("name", s.getName());
            row.put("p1", avgP1);
            row.put("p2", avgP2);
            row.put("p3", avgP3);

            if (avgP3 == 0) {
                double currentSum = (avgP1 + avgP2);
                double needed = 18.0 - currentSum;
                row.put("projection", Math.max(0, needed));
            }

            results.add(row);
        }
        return results;
    }

    private double calculateAverage(List<Grade> grades, LocalDate start, LocalDate end) {
        return grades.stream()
                .filter(g -> !g.getRegistrationDate().isBefore(start) && !g.getRegistrationDate().isAfter(end))
                .mapToDouble(Grade::getGradeValue)
                .average()
                .orElse(0.0);
    }
}