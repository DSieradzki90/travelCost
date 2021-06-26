package dsieradzki.pl.travelcost.webclient.travel.dto.DistanceDto;

import lombok.Getter;

@Getter
public class Row {

    private Distance distance;
    private Duration duration;
    private Element[] elements;

}
