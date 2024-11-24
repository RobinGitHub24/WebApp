package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.model.KursNote;
import edu.fra.uas.model.Student;
import edu.fra.uas.service.StudentService;

@Controller
public class NotenController {

    @Autowired
    private StudentService studentService;

    private Student student = new Student("Max Mustermann");

    @GetMapping("/noten")
    public String getNoten(Model model) {
        model.addAttribute("noten", student.getNotenListe());
        model.addAttribute("durchschnitt", student.berechneDurchschnitt());
        return "noten"; // Name der HTML-Datei (ohne .html)
    }

    @PostMapping("/addNote")
    public String addNote(@RequestParam("kursName") String kursName, @RequestParam("note") double note, Model model) {
        student.addNote(new KursNote(kursName, note));
        model.addAttribute("noten", student.getNotenListe());
        model.addAttribute("durchschnitt", student.berechneDurchschnitt());
        return "redirect:/noten";
    }
}
