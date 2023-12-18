package bank;

import bank.service.BankProcessor;
import bank.service.BankService;

import java.util.Scanner;


public class BankApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ConsoleReader consoleReader = new ConsoleReader(scanner);

        BankService bankService = new BankService(consoleReader);
        BankProcessor bankProcessor = new BankProcessor(consoleReader, bankService);
        bankProcessor.init();


    }
}

