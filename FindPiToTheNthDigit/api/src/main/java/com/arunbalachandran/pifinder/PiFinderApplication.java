package com.arunbalachandran.pifinder;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class PiFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiFinderApplication.class, args);
    }
}