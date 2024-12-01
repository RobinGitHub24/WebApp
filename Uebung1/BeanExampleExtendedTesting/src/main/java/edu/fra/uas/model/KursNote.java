package edu.fra.uas.model;

public class KursNote {
    private String kursName;
    private double note;

    // Konstruktor
    public KursNote() {}

    public KursNote(String kursName, double note) {
        this.kursName = kursName;
        this.note = note;
    }

    // Getter und Setter
    public String getKursName() {
        return kursName;
    }

    public void setKursName(String kursName) {
        this.kursName = kursName;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
