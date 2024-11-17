package edu.fra.uas.v2setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Drilling implements Work {// beschreibt die Arbeit

    private static final Logger LOGGER = LoggerFactory.getLogger(Drilling.class); // Logger Instanz

    public void doWork(){ // fürht die abreit aus
        LOGGER.info(" --> drill a hole into the wall");//protokolliert die Nachricht
    }
}
