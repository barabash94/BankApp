package bank.service;

import bank.ConsoleReader;
import bank.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BankServiceTest {

    private final ConsoleReader consoleReader = mock(ConsoleReader.class);
    private final BankService bankService = new BankService(consoleReader);


    @Test
    void should_create_correct_account() {
        // given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(13, "Zofia", "joint", 1235000));
        when(this.consoleReader.readConsoleInt()).thenReturn(112);
        when(this.consoleReader.readConsoleLine()).thenReturn("Maria");
        when(this.consoleReader.readConsoleLine()).thenReturn("joint");
        when(this.consoleReader.readConsoleInt()).thenReturn(1230000);



        // when
        bankService.openAccount(accounts);

        // then
        Assertions.assertNotEquals(List.of(new Account(112, "Maria", "joint", 1230000)), accounts);

    }

    @Test
    public void should_find_by_id() {
        //given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(13, "Zofia", "joint", 1235000));
        accounts.add(new Account(134, "Suzie", "joint", 45000));
        when(this.consoleReader.readConsoleInt()).thenReturn(1);
        when(consoleReader.readConsoleLine()).thenReturn("");

        //when
        Account expected = new Account(13, "Zofia", "joint", 1235000);
        bankService.findByID(accounts);

        //then
        Assertions.assertNotEquals(expected,accounts.get(0));

    }
}

