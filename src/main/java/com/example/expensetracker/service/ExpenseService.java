package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseSummary;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAllExpenses () {
        return repository.findAllByOrderByDateDesc();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return repository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    public Optional<Expense> updateExpense(Long id, Expense updatedExpense) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(updatedExpense.getTitle());
            existing.setAmount(updatedExpense.getAmount());
            existing.setCategory(updatedExpense.getCategory());
            existing.setType(updatedExpense.getType());
            if (updatedExpense.getDate() != null) {
                existing.setDate(updatedExpense.getDate());
            }

            return repository.save(existing);
        });
    }

    public boolean deleteExpense(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public ExpenseSummary getSummary() {
        BigDecimal totalIncome = repository.sumAmountByType("INCOME");
        BigDecimal totalExpense = repository.sumAmountByType("EXPENSE");
        return new ExpenseSummary(totalIncome, totalExpense);
    }
}
