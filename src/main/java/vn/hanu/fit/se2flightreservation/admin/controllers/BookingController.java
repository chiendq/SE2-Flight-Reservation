package vn.hanu.fit.se2flightreservation.admin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.admin.converters.BookingConverter;
import vn.hanu.fit.se2flightreservation.admin.dtos.Booking.ResponseBookingDto;
import vn.hanu.fit.se2flightreservation.admin.services.BookingService;
import vn.hanu.fit.se2flightreservation.entities.Booking;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/admin/bookings")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final BookingService bookingService;

    private BookingConverter bookingConverter;

    public BookingController(BookingService bookingService, BookingConverter bookingConverter) {
        this.bookingService = bookingService;
        this.bookingConverter = bookingConverter;
    }

    @PostMapping("")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.save(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity<List<ResponseBookingDto>> getAllBookings() {
        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Credentials", String.valueOf(true))
                .body(bookingConverter.toResponseBookingDtoList(bookingService.getAllBookings()));
    }

//    @GetMapping("")
//    public ResponseEntity<List<Booking>> getAllBookings() {
//        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Origin", "*")
//                .body(bookingService.getAllBookings());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") int bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") int id, @RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.updateBooking(booking, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") int id) {
        bookingService.deleteBookingById(id);
        return new ResponseEntity<>("Booking deleted successfully!.", HttpStatus.OK);
    }

}
