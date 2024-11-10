// StudentService.java
package edu.fra.uas.service;

import edu.fra.uas.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public double berechneDurchschnitt(Student student) {
        return student.berechneDurchschnitt();
    }
}
