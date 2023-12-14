package bank;

import bank.service.BankProcessor;


public class BankApplication {

    public static void main(String[] args) {

        BankProcessor bankProcessor = new BankProcessor();
        bankProcessor.init();

    }
}

