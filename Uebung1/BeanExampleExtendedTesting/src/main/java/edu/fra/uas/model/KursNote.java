package edu.fra.uas.model;

public class KursNote {

    private String kursName;
    private double note;

    public KursNote(String kursName, double note) {
        this.kursName = kursName;
        this.note = note;
    }

    public String getKursName() {
        return kursName;
    }

    public double getNote() {
        return note;
    }
}
