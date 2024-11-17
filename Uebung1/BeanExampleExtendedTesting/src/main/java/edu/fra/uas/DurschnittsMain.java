package edu.fra.uas;

import edu.fra.uas.model.Student;
import edu.fra.uas.model.KursNote;
import edu.fra.uas.service.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DurschnittsMain implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    private Student student; // Ein einzelner Student

    public static void main(String[] args) {
        SpringApplication.run(DurschnittsMain.class, args);
    }

    @PostConstruct
    public void init() {
        // Initialisierung des Studenten
        student = new Student("Max Mustermann");
        student.addNote(new KursNote("Mathematik", 2.0));
        student.addNote(new KursNote("Informatik", 1.7));
        student.addNote(new KursNote("Physik", 2.3));
        System.out.println("Student initialisiert: " + student.getName());
    }

    @Override
    public void run(String... args) {
        // Berechnung des Durchschnitts für den initialisierten Studenten
        double durchschnitt = studentService.berechneDurchschnitt(student);
        System.out.println("Der Notendurchschnitt von " + student.getName() + " beträgt: " + durchschnitt);
    }

    @PreDestroy
    public void cleanup() {
        // Bereinigung der Daten
        student = null;
        System.out.println("Studentendaten wurden gelöscht.");
    }
}
