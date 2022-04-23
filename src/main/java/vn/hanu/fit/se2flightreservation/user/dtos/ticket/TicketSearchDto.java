package vn.hanu.fit.se2flightreservation.user.dtos.ticket;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.hanu.fit.se2flightreservation.enums.ERoundTrip;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketSearchDto implements Serializable {
    private String departure;

    private String destination;

    private String ticketClass;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date departureDate;

    private ERoundTrip isRoundTrip;
}
