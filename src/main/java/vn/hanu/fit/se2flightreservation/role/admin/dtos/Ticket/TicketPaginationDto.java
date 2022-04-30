package vn.hanu.fit.se2flightreservation.role.admin.dtos.Ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketPaginationDto {
    private int totalElements;
    private int totalPage;
    private List<ResponseTicketDto> items;
}
