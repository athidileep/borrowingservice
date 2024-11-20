package com.library.borrowingservice.repos;

import com.library.borrowingservice.entities.BooksBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksBorrowingRepo extends JpaRepository<BooksBorrowing, Long> {

    // Find all borrowings by userId
    List<BooksBorrowing> findByUserId(Long userId);

    // Find borrowings by borrowingId
    List<BooksBorrowing> findByBorrowingId(Long borrowingId);
}
