package com.example.expensetracker.dto;

import java.math.BigDecimal;

public class ExpenseSummary {

    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;

    public ExpenseSummary(BigDecimal totalIncome, BigDecimal totalExpense){
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = totalIncome.subtract(totalExpense);
    }

    public BigDecimal getTotalIncome() { return  totalIncome;}
    public BigDecimal getTotalExpense() { return  totalExpense;}
    public BigDecimal getBalance() { return  balance;}

}
