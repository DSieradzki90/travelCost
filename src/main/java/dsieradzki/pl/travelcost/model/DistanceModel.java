package dsieradzki.pl.travelcost.model;

import lombok.*;

@Getter
@Builder
@Setter
public class DistanceModel {

    public int value;

    public int getDistanceInKm(){
        return value/1000;
    }
}
