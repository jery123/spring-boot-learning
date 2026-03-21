package com.pop2c.aopdemo;

import com.pop2c.aopdemo.dao.AccountDAO;
import com.pop2c.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {
            //
            // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            // demoTheAfterReturningAdvice(theAccountDAO);
            demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        // call method to find the accounts
        List<Account> theAccounts = null;

        try{
            // add a boolean flag to simulate exception
            boolean tripWire = true;
            theAccountDAO.findAccounts(tripWire);
        } catch (Exception e){
            System.out.println("Main Prgrma: ... caught exception: " + e);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("---------");

        System.out.println(theAccounts);

        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("---------");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		myAccount.setName("Alice");
		myAccount.setLevel("Gold");

        //call the business method
        theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

        // call the accountdao getter/setter methods
        theAccountDAO.setName("Bob");
        theAccountDAO.setServiceCode("pk_sc_1234567890");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addSillyMember();
		theMembershipDAO.goSleep();


    }

}
