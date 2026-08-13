package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //Find all transaction ordered by date ascending
    List<Expense> findAllByOrderByDateDesc();

    //Sum total by type (INCOME / EXPENSE)
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.type = :type")
    BigDecimal sumAmountByType(String type);
}
