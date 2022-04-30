package vn.hanu.fit.se2flightreservation.role.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutRequest;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutResponse;
import vn.hanu.fit.se2flightreservation.role.user.services.UBookingService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/checkout")
public class UCheckoutController {
    private static final Logger logger = LoggerFactory.getLogger(UCheckoutController.class);

    private UBookingService bookingService;

    public UCheckoutController(UBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("")
    public ResponseEntity<Booking> checkout(@RequestBody UCheckoutRequest checkoutRequest){
        return new ResponseEntity<Booking>(bookingService.save(checkoutRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<UCheckoutResponse> getBooking(@PathVariable("code") String code){
        return new ResponseEntity<UCheckoutResponse>(bookingService.getBookingByCode(code), HttpStatus.CREATED);
    }
}
