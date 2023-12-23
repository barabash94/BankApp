package bank.service;

import bank.ConsoleReader;
import bank.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


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
        when(consoleReader.readConsoleInt()).thenReturn(1);
        when(consoleReader.readConsoleLine()).thenReturn("");

        //when

        bankService.findByID(accounts);

        //then
        Account expected = new Account(13, "Zofia", "joint", 1235000);
        assertNotEquals(expected, accounts.get(0));

    }

    @Test

    public void should_verify_FindById_method() {
        //given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(11, "Betty", "joint", 1235000));
        accounts.add(new Account(27, "Cara", "joint", 45000));
        when(consoleReader.readConsoleInt()).thenReturn(2);

        //when

        bankService.findByID(accounts);

        //then

        verify(consoleReader, times(2)).readConsoleInt();

    }

    @Test
    public void testFindByID_WhenAccountNotFound_ThrowsException() {

        //given

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(11, "Betty", "joint", 1235000));
        accounts.add(new Account(27, "Cara", "joint", 45000));
        when(consoleReader.readConsoleInt()).thenReturn(-1);

        //when

        final var exception = assertThrows(IllegalStateException.class, () -> bankService.findByID(accounts));


        //then

        assertEquals("Account not found", exception.getMessage());
        assertTrue(exception.getMessage().contains("Account not found"));


    }


}






