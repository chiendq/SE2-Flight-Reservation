package vn.hanu.fit.se2flightreservation.user.services;

import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.UCheckoutRequest;
import vn.hanu.fit.se2flightreservation.user.dtos.checkout.UCheckoutResponse;

public interface UBookingService {

    Booking save(UCheckoutRequest checkoutRequest);

    UCheckoutResponse getBookingByCode(String code);
}
