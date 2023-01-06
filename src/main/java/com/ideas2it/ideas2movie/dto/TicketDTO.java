package com.ideas2it.ideas2movie.dto;

import jakarta.persistence.SecondaryTable;

import com.ideas2it.ideas2movie.model.Seat;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {
    //private ShowDTO showDTO;
    private List<Seat> seats;
    private double price;
}
