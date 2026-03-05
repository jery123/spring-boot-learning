package com.pop2c.aopdemo;

import com.pop2c.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {

		return runner -> {
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

        //call the business method
        theAccountDAO.addAccount();

        // do it again
        System.out.println("\n Let's do it again!");

        // second time
        theAccountDAO.addAccount();

    }

}
