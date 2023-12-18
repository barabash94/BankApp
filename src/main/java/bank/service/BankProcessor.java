package bank.service;

import bank.ConsoleReader;
import bank.model.Account;

import java.util.ArrayList;
import java.util.List;

public class BankProcessor {

   private final ConsoleReader consoleReader ;
    private final BankService bankService ;

    public BankProcessor(ConsoleReader consoleReader, BankService bankService) {
        this.consoleReader = consoleReader;
        this.bankService = bankService;
    }


    public void init() {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(997,"Mateo","savings",20000000));
        accounts.add(new Account(999,"Barabasz","Savings",4500000));

        while (true) {
            bankService.printOptions();
            int choice = 0;

            try {
                choice = consoleReader.readConsoleInt();
            } catch (Exception e) {
                System.out.println("Use numbers!!");
                System.err.println(e.getMessage());
                e.printStackTrace();
                break;
            }


            switch (choice) {

                case 1:
                    bankService.openAccount(accounts);
                    break;
                case 2:
                    bankService.printAllAccounts(accounts);
                    break;
                case 3:
                    bankService.findByID(accounts);
                    break;
                case 4:
                    bankService.deposit(accounts);
                    break;
                case 5:
                    bankService.withdraw(accounts);
                    break;
                case 6:
                    bankService.exit(accounts);
                    break;


                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;


            }
            System.out.println();
        }
    }
}
