package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.fra.uas.model.KursNote;
import edu.fra.uas.model.Student;
import edu.fra.uas.service.StudentService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/grades")
public class NotenRestController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Hole alle Noten", description = "Gibt eine Liste aller Noten des Studenten zurück")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Erfolgreiche Abfrage")
    })
    @GetMapping("/all")
    public ResponseEntity<List<KursNote>> getAllNotes() {
        List<KursNote> notenListe = studentService.getStudent().getNotenListe();
        return ResponseEntity.ok(notenListe);
    }

    @Operation(summary = "Füge eine neue Note hinzu", description = "Speichert eine neue Note für den Studenten")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Note erfolgreich hinzugefügt"),
            @ApiResponse(responseCode = "400", description = "Ungültige Eingabedaten")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addNote(@RequestBody KursNote kursNote) {
        if (kursNote.getKursName() == null || kursNote.getKursName().isEmpty()) {
            return ResponseEntity.badRequest().body("Kursname darf nicht leer sein");
        }
        if (kursNote.getNote() < 1.0 || kursNote.getNote() > 6.0) {
            return ResponseEntity.badRequest().body("Die Note muss zwischen 1.0 und 6.0 liegen");
        }
        studentService.getStudent().addNote(kursNote);
        return ResponseEntity.ok("Note hinzugefügt");
    }

    @Operation(summary = "Berechne den Notendurchschnitt", description = "Berechnet und gibt den Durchschnitt der Noten zurück")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Durchschnitt erfolgreich berechnet")
    })
    @GetMapping("/average")
    public ResponseEntity<Double> getAverage() {
        double durchschnitt = studentService.getStudent().berechneDurchschnitt();
        return ResponseEntity.ok(durchschnitt);
    }

    @Operation(summary = "Lösche eine Note", description = "Entfernt eine Note basierend auf dem Kursnamen")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Note erfolgreich gelöscht"),
            @ApiResponse(responseCode = "404", description = "Kursname nicht gefunden")
    })
    @DeleteMapping("/delete/{kursName}")
    public ResponseEntity<String> deleteNote(@PathVariable String kursName) {
        Student student = studentService.getStudent();
        boolean removed = student.getNotenListe().removeIf(note -> note.getKursName().equals(kursName));
        if (removed) {
            return ResponseEntity.ok("Note gelöscht");
        } else {
            return ResponseEntity.status(404).body("Kurs nicht gefunden");
        }
    }
}
