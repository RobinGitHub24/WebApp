package edu.fra.uas;

import edu.fra.uas.model.Student;
import edu.fra.uas.model.KursNote;
import edu.fra.uas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DurschnittsMain implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(DurschnittsMain.class, args);
    }

    @Override
    public void run(String... args) {
        // Beispiel: Erstellung eines Studenten mit Noten
        Student student = new Student("Max Mustermann");
        student.addNote(new KursNote("Mathematik", 2.0));
        student.addNote(new KursNote("Informatik", 1.7));
        student.addNote(new KursNote("Physik", 2.3));

        // Berechnung des Durchschnitts
        double durchschnitt = studentService.berechneDurchschnitt(student);

        // Ausgabe des Durchschnitts
        System.out.println("Der Notendurchschnitt von " + student.getName() + " beträgt: " + durchschnitt);
    }
}
