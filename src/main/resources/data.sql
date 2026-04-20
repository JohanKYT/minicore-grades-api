-- Estudiantes
INSERT INTO students (name) VALUES ('Kevin Maquis');
INSERT INTO students (name) VALUES ('Juan Antamba');
INSERT INTO students (name) VALUES ('Andrea Segovia');
INSERT INTO students (name) VALUES ('Jean Ethienne');
INSERT INTO students (name) VALUES ('Rodrigo Andrade');

-- Notas Progreso 1 (Enero 2024)
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (1, 7.5, '2024-01-15');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (2, 8.0, '2024-01-16');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (3, 5.0, '2024-01-15');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (4, 9.0, '2024-01-18');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (5, 6.5, '2024-01-20');

-- Notas Progreso 2 (Febrero 2024)
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (1, 6.0, '2024-02-10');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (2, 7.0, '2024-02-11');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (3, 4.5, '2024-02-10');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (4, 8.5, '2024-02-12');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (5, 7.0, '2024-02-15');

-- Notas Progreso 3 (Marzo 2024 - Dejamos a algunos sin nota para probar el botón de Proyección)
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (2, 8.0, '2024-03-05');
INSERT INTO grades (student_id, grade_value, registration_date) VALUES (4, 9.5, '2024-03-06');