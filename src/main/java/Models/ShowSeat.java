package Models;

import Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;
     @Enumerated(value = EnumType.STRING)
     private SeatType seatType;
    private String seatNo;
    private boolean isAvailable;
    private boolean isFoodAttached;



    public Integer getShowSeatId() {
        return showSeatId;
    }

    public void setShowSeatId(Integer showSeatId) {
        this.showSeatId = showSeatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isFoodAttached() {
        return isFoodAttached;
    }

    public void setFoodAttached(boolean foodAttached) {
        isFoodAttached = foodAttached;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    private Integer cost;

    @ManyToOne
    @JoinColumn
    private Show show;

}
