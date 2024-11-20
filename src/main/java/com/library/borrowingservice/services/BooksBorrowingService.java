package com.library.borrowingservice.services;

import com.library.borrowingservice.entities.BooksBorrowing;
import com.library.borrowingservice.repos.BooksBorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksBorrowingService {

    @Autowired
	private BooksBorrowingRepo booksBorrowingRepo;
    
    public BooksBorrowing createBorrowing(BooksBorrowing booksBorrowing) {
        booksBorrowing.setBorrowDate(LocalDate.now());
        booksBorrowing.setDueDate(LocalDate.now().plusDays(14)); // Example: 2-week borrowing period
        booksBorrowing.setStatus(null); // No status initially, can be set later
        return booksBorrowingRepo.save(booksBorrowing);
    }

    public List<BooksBorrowing> getBorrowingsByUserId(Long userId) {
        return booksBorrowingRepo.findByUserId(userId);
    }

    public BooksBorrowing markAsReturned(Long borrowingId) {
        BooksBorrowing borrowing = booksBorrowingRepo.findById(borrowingId)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
        
        borrowing.setStatus("returned"); // Mark status as "returned"
        return booksBorrowingRepo.save(borrowing);
    }

    public BooksBorrowing markAsOverdue(Long borrowingId) {
        BooksBorrowing borrowing = booksBorrowingRepo.findById(borrowingId)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
        
        borrowing.setStatus("overdue"); // Mark status as "overdue"
        return booksBorrowingRepo.save(borrowing);
    }

 // Method to update the status of a borrowing
    public BooksBorrowing updateStatus(Long borrowingId, String status) {
        BooksBorrowing booksBorrowing = booksBorrowingRepo.findById(borrowingId)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));
        booksBorrowing.setStatus(status);
        return booksBorrowingRepo.save(booksBorrowing);
    }
}
