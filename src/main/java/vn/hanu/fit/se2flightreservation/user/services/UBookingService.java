package vn.hanu.fit.se2flightreservation.user.services;

import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.CheckoutResponse;

public interface UBookingService {

    Booking save(CheckoutRequest checkoutRequest);

    CheckoutResponse getBookingByCode(String code);
}
