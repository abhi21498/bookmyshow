package RequestDTOs;

import Enums.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTheatreRequest {

    private String name;

    private String address;

    private City city;

    private Integer noOfClassicSeats;

    private Integer noOfPremiumSeats;

    private Integer noOfSeatsPerRow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getNoOfClassicSeats() {
        return noOfClassicSeats;
    }

    public void setNoOfClassicSeats(Integer noOfClassicSeats) {
        this.noOfClassicSeats = noOfClassicSeats;
    }

    public Integer getNoOfPremiumSeats() {
        return noOfPremiumSeats;
    }

    public void setNoOfPremiumSeats(Integer noOfPremiumSeats) {
        this.noOfPremiumSeats = noOfPremiumSeats;
    }

    public Integer getNoOfSeatsPerRow() {
        return noOfSeatsPerRow;
    }

    public void setNoOfSeatsPerRow(Integer noOfSeatsPerRow) {
        this.noOfSeatsPerRow = noOfSeatsPerRow;
    }
}
