package dsieradzki.pl.travelcost.service;

import dsieradzki.pl.travelcost.model.DistanceModel;
import dsieradzki.pl.travelcost.webclient.travel.TravelCostClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DistanceService {

    private final TravelCostClient travelCostClient;

    public DistanceModel getCoordinates(String start,String end) throws Exception {
        if (start.isBlank() || end.isBlank()){
            throw new Exception("Please type city");
        }
        return travelCostClient.getCoordinatesForCity(start, end);
    }



}
