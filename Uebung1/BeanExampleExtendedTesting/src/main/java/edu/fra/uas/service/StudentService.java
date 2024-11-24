package edu.fra.uas.service;

import edu.fra.uas.model.Student;
import org.springframework.stereotype.Service;

@Service // Spring erkennt diese Klasse als Service-Bean
public class StudentService {

    private final Student student; // Ein zentral verwalteter Student

    // Konstruktor, um den Student zu initialisieren
    public StudentService() {
        this.student = new Student("Max Mustermann");
    }

    // Zugriff auf den zentralen Student
    public Student getStudent() {
        return this.student;
    }

    // Methode zur Berechnung des Notendurchschnitts
    public double berechneDurchschnitt() {
        return this.student.berechneDurchschnitt(); // Aufruf der Methode in der Student-Klasse
    }
}
