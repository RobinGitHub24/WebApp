package edu.fra.uas.v2setter;

public class Journeyman { //Klasse des Journeyman
    Work work;  //attribut für arbeit

    public Journeyman setWork(Work work) { //weißt dem Journeyman die Arbeit zu
        this.work = work;
        return this;
    }

    public void performWork() { //fürht die Arbeit aus denn methode dowork aus work objekt aus
        work.doWork();
    }
}
