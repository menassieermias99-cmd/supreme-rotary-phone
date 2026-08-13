package com.example.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Category is required")
    private String category; // e.g "food", "rent" , "transport", "entertainment", "salary"

    @NotNull(message = "Type is required")
    @Pattern(regexp = "^(INCOME|EXPENSE)$", message = "Type must be either INCOME or EXPENSE")
    private String type;

    private LocalDate date;

    //default constructor
    public Expense(){
        this.date = LocalDate.now();
    }

    public Expense(String title, BigDecimal amount, String category, String type, LocalDate date){
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.type = type;
        this.date = ( date != null ) ? date : LocalDate.now();
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
}
