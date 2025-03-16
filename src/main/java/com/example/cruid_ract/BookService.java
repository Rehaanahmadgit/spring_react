package com.example.cruid_ract;

import com.example.cruid_ract.entity;
import com.example.cruid_ract.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private static jpa bookRepository;

    private static final int FINE_PER_DAY = 2; // Fine amount per day

    // Method to calculate fine for a book
    public static int calculateFine(Long id, LocalDate returnDate) {
        Optional<entity> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            entity book = bookOptional.get();
            LocalDate dueDate = book.getDueDate(); // Assuming Book entity has a dueDate field

            if (returnDate.isAfter(dueDate)) {
                long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
                return (int) (daysLate * FINE_PER_DAY);
            }
        }
        return 0;// No fine if book is returned on time
    }
    public static  int duedate(LocalDate date) {
        LocalDate today= LocalDate.now();
//        LocalDate duedate=today.ad
        return 0;
    }
}
