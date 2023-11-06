package Models;

import Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theatre_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheatreSeat {
    public Integer getTheatreSeatId() {
        return theatreSeatId;
    }

    public void setTheatreSeatId(Integer theatreSeatId) {
        this.theatreSeatId = theatreSeatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theatreSeatId;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

}
