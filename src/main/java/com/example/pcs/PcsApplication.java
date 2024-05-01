package com.example.pcs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.pcs.entities.Pc;
import com.example.pcs.service.PcService;
@SpringBootApplication
public class PcsApplication implements CommandLineRunner {
@Autowired
PcService PcService;
public static void main(String[] args) {
SpringApplication.run(PcsApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
PcService.savePc(new Pc("PC Dell", 2600.0, "Specs example"));
PcService.savePc(new Pc("PC Asus", 2800.0, "Specs example 2"));
PcService.savePc(new Pc("Msi GF 63", 900.0,"Specs example 3"));
}
}
