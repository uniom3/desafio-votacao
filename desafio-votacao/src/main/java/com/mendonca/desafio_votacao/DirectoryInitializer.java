package com.mendonca.desafio_votacao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        File directory = new File("./data");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
