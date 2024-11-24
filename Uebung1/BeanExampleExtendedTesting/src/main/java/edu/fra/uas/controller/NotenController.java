package edu.fra.uas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.model.KursNote;
import edu.fra.uas.service.StudentService;

@Controller
public class NotenController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/noten")
public String getNoten(Model model) {
    model.addAttribute("noten", studentService.getStudent().getNotenListe());
    model.addAttribute("durchschnitt", studentService.getStudent().berechneDurchschnitt());
    return "noten"; // sicherstellen, dass es "noten.html" in src/main/resources/templates gibt
}

    

    @PostMapping("/addNote")
public String addNote(@RequestParam("kursName") String kursName, @RequestParam("note") double note) {
    studentService.getStudent().addNote(new KursNote(kursName, note));
    return "redirect:/noten"; // Korrekt, um einen neuen GET-Request auszulösen
}

}
