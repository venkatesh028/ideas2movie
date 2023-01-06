package com.ideas2it.ideas2movie.dto.responsedto;

import com.ideas2it.ideas2movie.model.Seat;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {
    private Long ticketId;
    //private ShowResponseDTO showResponseDTO;
    private LocalDate showDate;
    private List<Seat> seats;
}
