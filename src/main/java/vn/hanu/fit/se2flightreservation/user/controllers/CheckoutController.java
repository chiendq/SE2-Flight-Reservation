package vn.hanu.fit.se2flightreservation.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.services.UBookingService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {
    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    private UBookingService bookingService;

    public CheckoutController(UBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("")
    public ResponseEntity<Booking> checkout(@RequestBody CheckoutRequest checkoutRequest){
        return new ResponseEntity<Booking>(bookingService.save(checkoutRequest), HttpStatus.CREATED);
    }
}
