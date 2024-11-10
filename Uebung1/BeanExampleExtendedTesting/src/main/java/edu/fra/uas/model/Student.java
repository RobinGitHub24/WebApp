// Student.java
package edu.fra.uas.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<KursNote> notenListe;

    public Student(String name) {
        this.name = name;
        this.notenListe = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<KursNote> getNotenListe() {
        return notenListe;
    }

    public void addNote(KursNote kursNote) {
        this.notenListe.add(kursNote);
    }

    public double berechneDurchschnitt() {
        if (notenListe.isEmpty()) {
            return 0.0;
        }
        double summe = 0;
        for (KursNote kursNote : notenListe) {
            summe += kursNote.getNote();
        }
        return summe / notenListe.size();
    }
}
