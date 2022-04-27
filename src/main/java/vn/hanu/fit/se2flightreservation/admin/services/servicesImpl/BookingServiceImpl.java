package vn.hanu.fit.se2flightreservation.admin.services.servicesImpl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.repositories.BookingRepository;
import vn.hanu.fit.se2flightreservation.admin.services.BookingService;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int id) {
        return null;
    }

    @Override
    public Booking updateBooking(Booking booking, int id) {
        return null;
    }

    @Override
    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookingRepository.deleteAll();
    }
}
