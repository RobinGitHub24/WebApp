package edu.fra.uas.v2setter;

public class MasterV2 {
    Journeyman journeyman; //Atribut für den journeyman

    public void setJourneymanAndWork(Journeyman journeyman, Work work) { //methode erzeugt jouneyman und weist ihm die arbeit die er machen soll zu
        this.journeyman = journeyman;
        this.journeyman.setWork(work);
    }

    public void delegateWork() {    //methode überträgt arbeit an journeyman und  ruft work methode auf
        journeyman.performWork();
    }
}
