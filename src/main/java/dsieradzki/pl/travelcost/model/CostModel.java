package dsieradzki.pl.travelcost.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class CostModel {

    private int totalKilometers;
    private int tripCost;

}
