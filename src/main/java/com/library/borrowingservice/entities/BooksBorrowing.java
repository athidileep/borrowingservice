package com.library.borrowingservice.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books_borrowing")
public class BooksBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Long borrowingId; // Unique ID for each borrowing transaction
    
    @Column(name = "user_id")
    private Long userId; // User who is borrowing the book
    
    @Column(name = "book_id")
    private Long bookId; // The book being borrowed
    
    @Column(name = "borrow_date")
    private LocalDate borrowDate; // The date when the book is borrowed
    
    @Column(name = "return_date")
    private LocalDate dueDate; // The due date for returning the book
    
    @Column(name = "status")
    private String status; // Status of the book: "borrowed", "returned", "overdue", or null

    // Getters and Setters

    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
