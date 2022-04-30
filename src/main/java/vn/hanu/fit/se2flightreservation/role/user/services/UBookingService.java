package vn.hanu.fit.se2flightreservation.role.user.services;

import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutResponse;
import vn.hanu.fit.se2flightreservation.role.user.dtos.checkout.UCheckoutRequest;

public interface UBookingService {

    Booking save(UCheckoutRequest checkoutRequest);

    UCheckoutResponse getBookingByCode(String code);
}
