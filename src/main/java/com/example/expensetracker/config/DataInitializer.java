package com.example.expensetracker.config;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ExpenseRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Expense("Monthly Salary", new BigDecimal("3500.00"), "Income", "INCOME", LocalDate.now().minusDays(5)),
                    new Expense("Grocery Shopping", new BigDecimal("120.50"), "Food", "EXPENSE", LocalDate.now().minusDays(3)),
                    new Expense("Eletric Bill", new BigDecimal("85.00"), "Utilities", "EXPENSE", LocalDate.now().minusDays(1)),
                    new Expense("Freelance Web Design", new BigDecimal("450.00"), "Income", "INCOME", LocalDate.now())
            ));
        };
    }
}
