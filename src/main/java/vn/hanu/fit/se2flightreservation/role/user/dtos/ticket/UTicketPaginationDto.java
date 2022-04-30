package vn.hanu.fit.se2flightreservation.role.user.dtos.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UTicketPaginationDto {
    private int totalElements;
    private int totalPage;
    private List<UTicketResponseDto> items;
}
