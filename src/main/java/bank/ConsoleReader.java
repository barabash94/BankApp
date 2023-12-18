package bank;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readConsoleLine() {
        return scanner.nextLine();// zwrocenie wyniku metody nextLine wywołanej na obiekcie scanner

    }

    public int readConsoleInt() {
        return scanner.nextInt();// zwrocenie wyniku metody nextInt wywołanej na obiekcie scanner
    }
}
