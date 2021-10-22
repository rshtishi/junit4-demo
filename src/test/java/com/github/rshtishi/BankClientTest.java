package com.github.rshtishi;


import com.github.rshtishi.doc.BankAccount;
import com.github.rshtishi.doc.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest({BankClient.class})
@RunWith(PowerMockRunner.class)
public class BankClientTest {

    @Test
    public void shouldOpenBankAccountSuccessfully() throws Exception {
        BankClient bankClient = new BankClient();
        Validator validator = mock(Validator.class);
        when(validator.validate(anyDouble())).thenReturn(true);
        when(validator.validate(anyString())).thenReturn(true);
        whenNew(Validator.class).withNoArguments().thenReturn(validator);
        BankAccount bankAccount = bankClient.openBankAccount(5, "USD");
        verifyNew(Validator.class).withNoArguments();
        assertNotNull(bankAccount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInvalidArgumentAreProvided() throws Exception {
        BankClient bankClient = new BankClient();
        Validator validator = mock(Validator.class);
        when(validator.validate(anyDouble())).thenReturn(false);
        when(validator.validate(anyString())).thenReturn(false);
        whenNew(Validator.class).withNoArguments().thenReturn(validator);
        BankAccount bankAccount = bankClient.openBankAccount(5, "USD");
    }

}