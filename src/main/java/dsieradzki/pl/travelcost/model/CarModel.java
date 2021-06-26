package dsieradzki.pl.travelcost.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class CarModel {

    public int entryFee;
    public double feePerKm;
}
