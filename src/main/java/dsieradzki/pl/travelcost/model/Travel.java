package dsieradzki.pl.travelcost.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Travel {

    private String start;
    private String end;
}
