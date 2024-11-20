package com.library.borrowingservice.controllers;

import com.library.borrowingservice.entities.BooksBorrowing;
import com.library.borrowingservice.services.BooksBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
@RequiredArgsConstructor
public class BooksBorrowingController {

    @Autowired
	private BooksBorrowingService booksBorrowingService;

    // Endpoint to create a new borrowing transaction
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BooksBorrowing createBorrowing(@RequestBody BooksBorrowing booksBorrowing) {
        return booksBorrowingService.createBorrowing(booksBorrowing);
    }

    // Endpoint to get borrowings by user ID
    @GetMapping("/user/{userId}")
    public List<BooksBorrowing> getBorrowingsByUser(@PathVariable Long userId) {
        return booksBorrowingService.getBorrowingsByUserId(userId);
    }

    // Endpoint to mark a borrowing as returned
    @PutMapping("/{borrowingId}/returned")
    public BooksBorrowing markAsReturned(@PathVariable Long borrowingId) {
        return booksBorrowingService.markAsReturned(borrowingId);
    }

    // Endpoint to mark a borrowing as overdue
    @PutMapping("/{borrowingId}/overdue")
    public BooksBorrowing markAsOverdue(@PathVariable Long borrowingId) {
        return booksBorrowingService.markAsOverdue(borrowingId);
    }

    // Endpoint to update the status of a borrowing transaction
    @PutMapping("/{borrowingId}/status")
    public BooksBorrowing updateStatus(@PathVariable Long borrowingId, @RequestParam String status) {
        return booksBorrowingService.updateStatus(borrowingId, status);
    }
}
