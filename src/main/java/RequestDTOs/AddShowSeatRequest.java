package RequestDTOs;

import lombok.Data;

@Data
public class AddShowSeatRequest {
    private Integer showId;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getPriceOfClassicSeats() {
        return priceOfClassicSeats;
    }

    public void setPriceOfClassicSeats(Integer priceOfClassicSeats) {
        this.priceOfClassicSeats = priceOfClassicSeats;
    }

    public Integer getPriceOfPremiumSeats() {
        return priceOfPremiumSeats;
    }

    public void setPriceOfPremiumSeats(Integer priceOfPremiumSeats) {
        this.priceOfPremiumSeats = priceOfPremiumSeats;
    }

    private Integer priceOfClassicSeats;

    private Integer priceOfPremiumSeats;
}
