package bank.service;

import bank.ConsoleReader;
import bank.model.Account;

import java.util.List;
import java.util.Scanner;

public class BankService {
    int deposit = 0;
    private final ConsoleReader consoleReader;


    public BankService(ConsoleReader consoleReader) {
        this.consoleReader= consoleReader;

    }

    public void printOptions() {
        System.out.println("Banking System Application ***");
        System.out.println("1.Open account");
        System.out.println("2.Display all accounts");
        System.out.println("3.Search by account ID");
        System.out.println("4.Deposit the amount");
        System.out.println("5.Withdraw the amount");
        System.out.println("6.Exit");
        System.out.println("Enter your choice: ");


    }


    public void openAccount(List<Account> accounts) {
        System.out.print("Enter Account No: ");
        int accountNo = consoleReader.readConsoleInt();
        System.out.print("Enter Name: ");
        String name = consoleReader.readConsoleLine();
        consoleReader.readConsoleLine();
        System.out.print("Enter Balance: ");
        int balance = consoleReader.readConsoleInt();
        consoleReader.readConsoleInt();
        System.out.print("Enter Account type:( Checking,Savings,Business, Joint) ");
        String accountType = consoleReader.readConsoleLine();
        if (isValidAccountType(accountType)) {
            accounts.add(new Account(accountNo, name, accountType, balance));
            System.out.println("Account has been  opened successfully");
        } else {
            System.out.println("Wrong type");
        }

    }


    private boolean isValidAccountType(String type) {
        return type.equalsIgnoreCase("Checking") ||
                type.equalsIgnoreCase("Savings") ||
                type.equalsIgnoreCase("Business") ||
                type.equalsIgnoreCase("Joint");

    }

    public void printAllAccounts(List<Account> accounts) {
        System.out.println("All details:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void findByID(List<Account> accounts) {
        System.out.print("Enter the account id: ");
        int id =consoleReader.readConsoleInt();
        consoleReader.readConsoleInt();
        for (Account account : accounts) {
            if (account.getId() == id) {
                System.out.print(account);
            } else {
                System.out.println("Account not found");
            }
        }
    }

        public void deposit (List < Account > accounts) {
            System.out.print("Enter the account id: ");
            int id = consoleReader.readConsoleInt();
            consoleReader.readConsoleInt();
            for (Account account : accounts) {
                if (account.getId() == id) {
                    System.out.println("Your current balance is" + " " + account.getBalance() + " ");
                    System.out.print("Enter the amount you want to deposit to account balance :");
                    deposit = consoleReader.readConsoleInt();
                    consoleReader.readConsoleInt();
                    int newBalance = account.getBalance() + deposit;
                    account.setBalance(newBalance);
                    System.out.println("Your new balance is:" + account.getBalance());
                    break;
                }
            }
        }

        public void withdraw (List < Account > accounts) {
            System.out.println("Enter the account id");
            int id = consoleReader.readConsoleInt();

            for (Account account : accounts) {
                if (account.getId() == id) {
                    System.out.println("Your current balance is" + " " + account.getBalance() + " ");
                    System.out.println("Enter the amount you want to withdraw:");
                    int withdraw = consoleReader.readConsoleInt();
                    consoleReader.readConsoleLine();
                    if (account.getBalance() >= withdraw) {
                        int newBalance = account.getBalance() - withdraw;
                        account.setBalance(newBalance);
                        System.out.println("Your balance after withdraw is" + " " + account.getBalance());
                    } else {
                        System.out.println("Your balance is less than " + " " + withdraw + " " + "Transaction failed...!!");

                    }
                }

            }

        }

        public void exit (List < Account > accounts) {
            System.out.println("See you next time!");

        }
    }


