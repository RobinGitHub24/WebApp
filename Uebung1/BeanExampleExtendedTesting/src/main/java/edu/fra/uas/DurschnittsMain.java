package edu.fra.uas;

import edu.fra.uas.model.KursNote;
import edu.fra.uas.service.StudentService;

import jakarta.annotation.PostConstruct;

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

    @PostConstruct
    public void init() {
        studentService.getStudent().addNote(new KursNote("Mathematik", 2.0));
        studentService.getStudent().addNote(new KursNote("Informatik", 1.7));
        studentService.getStudent().addNote(new KursNote("Physik", 2.3));
        System.out.println("Student initialisiert: " + studentService.getStudent().getName());
    }

    @Override
    public void run(String... args) {
        double durchschnitt = studentService.getStudent().berechneDurchschnitt();
        System.out.println("Der Notendurchschnitt beträgt: " + durchschnitt);
    }
}
