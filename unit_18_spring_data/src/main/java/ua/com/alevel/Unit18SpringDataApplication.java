package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.controller.MainController;

@SpringBootApplication
public class Unit18SpringDataApplication {

    @Autowired
    private MainController mainController;

    public static void main(String[] args) {
        SpringApplication.run(Unit18SpringDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        mainController.start();
    }
}
