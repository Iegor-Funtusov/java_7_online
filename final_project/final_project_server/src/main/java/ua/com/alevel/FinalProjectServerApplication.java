package ua.com.alevel;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

@SpringBootApplication
public class FinalProjectServerApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
//        String pass = "Test123!";
//        String res = passwordEncoder.encode(pass);
//        System.out.println("res = " + res);
//        res = passwordEncoder.encode(pass);
//        System.out.println("res = " + res);
//        res = passwordEncoder.encode(pass);
//        System.out.println("res = " + res);
//
//        String originalPassword = "$2a$10$WTBDVG4H0vwkUcbHoELF4.gVygvjX2FUn4ixK9VOepk4T5kbPXePC";
//        res = passwordEncoder.encode(pass);
//        System.out.println("originalPassword = " + originalPassword);
//        System.out.println("res = " + res);
//        System.out.println(res.equals(originalPassword));
//        System.out.println(passwordEncoder.matches(pass, res));
    }
}
