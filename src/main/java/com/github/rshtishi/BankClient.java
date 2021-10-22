package com.github.rshtishi;

import com.github.rshtishi.doc.BankAccount;
import com.github.rshtishi.doc.Validator;

public class BankClient {

    public BankAccount openBankAccount(double amount, String currency) {
        Validator validator = new Validator();
        if (validator.validate(amount) && validator.validate(currency)) {
            BankAccount bankAccount = new BankAccount(amount, currency);
            return bankAccount;
        }
        throw new IllegalArgumentException("Illegal Input passed to openBankAccount method");
    }
}
