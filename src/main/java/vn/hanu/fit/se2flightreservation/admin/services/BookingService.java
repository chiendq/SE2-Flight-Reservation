package vn.hanu.fit.se2flightreservation.admin.services;

import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Booking;

import java.util.List;

public interface BookingService {

    Booking save(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(int id);

    Booking updateBooking(Booking booking, int id);

    void deleteBookingById(int id);
}
