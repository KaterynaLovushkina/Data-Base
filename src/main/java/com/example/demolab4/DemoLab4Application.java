package com.example.demolab4;

import com.example.demolab4.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLab4Application implements CommandLineRunner {

    @Autowired
    private View view;

    public static void main(String[] args) {

        SpringApplication.run(DemoLab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }

}
