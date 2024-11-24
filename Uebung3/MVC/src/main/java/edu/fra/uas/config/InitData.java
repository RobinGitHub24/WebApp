package edu.fra.uas.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.User;
import edu.fra.uas.service.UserService;
import jakarta.annotation.PostConstruct;

@Component // Diese Annotation kennzeichnet die Klasse als Bean, die von Spring verwaltet wird
public class InitData {
// Logger-Instanz für das Protokollieren von Informationen während der Initialisierung
    private final Logger log = org.slf4j.LoggerFactory.getLogger(InitData.class);
    // Automatische Injektion des UserService, um Benutzeroperationen auszuführen
    @Autowired
    UserService userService;
// Diese Methode wird nach der Konstruktion der Bean ausgeführt
    @PostConstruct
    public void init() {
        log.debug("### Initialize Data ###");// Start der Initialisierung
        log.debug("create user admin");
        User user = new User();// Ein neues User-Objekt wird erstellt
        user.setRole("ADMIN");// Rolle wird auf ADMIN gesetzt
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("admin@example.com");
        user.setPassword("extremeSecurePassword1234");
        userService.createUser(user);// Benutzer wird über den UserService in die Datenbank eingefügt
// Erstellung eines regulären Benutzers Alice
        log.debug("create user alice");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Alice");
        user.setLastName("Adams");
        user.setEmail("alice@example.com");
        user.setPassword("alice1234");
        userService.createUser(user);

        log.debug("create user bob");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Bob");
        user.setLastName("Builder");
        user.setEmail("bob@example.com");
        user.setPassword("bob1234");
        userService.createUser(user);
        // Abschluss der Initialisierung
        log.debug("### Data initialized ###");
    }

}
