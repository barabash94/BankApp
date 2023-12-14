package bank.service;

import bank.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankProcessor {

    Scanner scanner = new Scanner(System.in);
    BankService bankService = new BankService();


    public void init() {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(997,"Mateo","savings",20000000));
        accounts.add(new Account(999,"Barabasz","Savings",4500000));

        while (true) {
            bankService.printOptions();
            int choice = 0;

            try {
                choice = scanner.nextInt();
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
