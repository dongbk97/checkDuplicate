package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Condition {
    private String bankCode;
    private String sourceResult;
    private String toAccount;

    public Condition(String bankCode, String sourceResult, String toAccount) {
        this.bankCode = bankCode;
        this.sourceResult = sourceResult;
        this.toAccount = toAccount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSourceResult() {
        return sourceResult;
    }

    public void setSourceResult(String sourceResult) {
        this.sourceResult = sourceResult;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public static List<Condition> listCondition() {
        return Arrays.asList(
                new Condition("MB", "LSGD", "1112"),
                new Condition("ACB", "CSDL", "1111"),
                new Condition("MB", "CSDL", "1112"),
                new Condition("ACB", "VTM", "1111"),
                new Condition("ACB", "CSDL", "1111"),
                new Condition("MB", "VTM", "1111"),
                new Condition("ACB", "LSGD", "1111"),
                new Condition("VTB", "LSGD", "1111"),
                new Condition("VTB", "CSDL", "1111"),
                new Condition("VTB", "VTM", "1111"),
                new Condition("MB", "CSDL", "1111"),
                new Condition("MB", "LSGD", "1111")
        );
    }
    public static List<Condition> listCondition2() {
        return Arrays.asList(

                new Condition("ACB", "LSGD", "1111"),
                new Condition("ACB", "CSDL", "1111"),
                new Condition("ACB", "VTM", "1111"),
                new Condition("MB", "LSGD", "1111"),
                new Condition("ACB", "VTM", "1111"),
                new Condition("ACB", "LSGD", "1111"),
                new Condition("MB", "VTM", "1111"),
                new Condition("MB", "CSDL", "1111"),
                new Condition("ACB", "VTM", "1111"),
                new Condition("ACB", "LSGD", "1111"),
                new Condition("MB", "CSDL", "1111")
        );
    }
    @Override
    public String toString() {
        return "Condition{" +
                "bankCode='" + bankCode + '\'' +
                ", sourceResult='" + sourceResult + '\'' +
                ", toAccount='" + toAccount + '\'' +
                '}';
    }
}
