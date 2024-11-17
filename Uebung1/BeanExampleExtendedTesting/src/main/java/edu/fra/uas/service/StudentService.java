package edu.fra.uas.service;

import edu.fra.uas.model.Student;
import org.springframework.stereotype.Service;

@Service// Spring erkennt diese Klasse als Service-Bean
public class StudentService {

    // Methode zur Berechnung des Notendurchschnitts
    public double berechneDurchschnitt(Student student) {
        return student.berechneDurchschnitt();  // Aufruf der Methode in der Student-Klasse
    }
}
