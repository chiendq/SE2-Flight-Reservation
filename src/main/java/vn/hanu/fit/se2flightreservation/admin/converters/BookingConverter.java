package vn.hanu.fit.se2flightreservation.admin.converters;

import org.springframework.stereotype.Component;
import vn.hanu.fit.se2flightreservation.admin.dtos.Booking.ResponseBookingDto;
import vn.hanu.fit.se2flightreservation.admin.dtos.Booking.UserBookingDto;
import vn.hanu.fit.se2flightreservation.admin.dtos.Ticket.ResponseTicketDto;
import vn.hanu.fit.se2flightreservation.entities.Booking;
import vn.hanu.fit.se2flightreservation.entities.Guest;
import vn.hanu.fit.se2flightreservation.entities.Ticket;
import vn.hanu.fit.se2flightreservation.entities.User;
import vn.hanu.fit.se2flightreservation.enums.EGender;
import vn.hanu.fit.se2flightreservation.enums.EPaymentMethod;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingConverter {
    private TicketConverter ticketConverter;

    public BookingConverter(TicketConverter ticketConverter) {
        this.ticketConverter = ticketConverter;
    }

    public ResponseBookingDto toResponseBookingDto(Booking booking){
        ResponseBookingDto responseBookingDto = new ResponseBookingDto();

        responseBookingDto.setId(booking.getId());
        String status = "";
        switch (booking.getStatus()){
            case STATUS_PENDING:
                status = "onCheckin";
                break;
            case STATUS_PAID:
                status = "online";
                break;
        }
        responseBookingDto.setStatus(status);

        responseBookingDto.setCreatedAt(booking.getCreatedAt().getTime());
        responseBookingDto.setPassengers(booking.getPassengers());
        User user = booking.getUser();
        if(user != null)         responseBookingDto.setUser(fromUserToUserBookingDto(booking.getUser()));
        else         responseBookingDto.setUser(fromPassengerToUserBookingDto(booking.getGuest()));

        String paymentMethod = "onCheckin";
        if(booking.getPaymentMethod().equals(EPaymentMethod.PAYMENT_ONLINE)) paymentMethod = "online";
        responseBookingDto.setPaymentMethod(paymentMethod);

        ArrayList<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: booking.getTickets()
             ) {
            tickets.add(ticket);
        }
        responseBookingDto.setTickets(ticketConverter.toResponseTicketDtoList(tickets));

        return responseBookingDto;
    }

    public UserBookingDto fromUserToUserBookingDto(User user){
        UserBookingDto userBookingDto = new UserBookingDto();

        userBookingDto.setId(user.getId());
        userBookingDto.setFullName(user.getFullname());
        userBookingDto.setPhoneNumber(user.getPhone());

        String gender = "male";
        if(user.getGender().equals(EGender.female)) gender = "female";
        userBookingDto.setGender(gender);
        return userBookingDto;
    }

    public UserBookingDto fromPassengerToUserBookingDto(Guest guest){
        UserBookingDto userBookingDto = new UserBookingDto();

        userBookingDto.setId(null);
        userBookingDto.setFullName(guest.getFullName());
        userBookingDto.setPhoneNumber(guest.getPhoneNumber());

        String gender = "male";
        if(guest.getGender().equals(EGender.female)) gender = "female";
        userBookingDto.setGender(gender);
        return userBookingDto;
    }

    public List<ResponseBookingDto> toResponseBookingDtoList(List<Booking> bookings) {
        List<ResponseBookingDto> responseTicketDtoList = new ArrayList<>();
        for (Booking booking: bookings
        ) {
            responseTicketDtoList.add(toResponseBookingDto(booking));
        }
        return responseTicketDtoList;
    }
}
