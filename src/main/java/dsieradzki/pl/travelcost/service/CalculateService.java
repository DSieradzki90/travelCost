package dsieradzki.pl.travelcost.service;

import dsieradzki.pl.travelcost.model.CarModel;
import dsieradzki.pl.travelcost.model.CostModel;
import dsieradzki.pl.travelcost.model.DistanceModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class CalculateService {

    private final DistanceService distanceService;

    public CostModel travelCost(String start, String end, String type) throws Exception {

        DistanceModel distance= distanceService.getCoordinates(start,end);
        CarModel car = getCostByType(type);

        return CostModel.builder()
                .totalKilometers(distance.getDistanceInKm())
                .tripCost((int) (car.getEntryFee()+car.getFeePerKm()*distance.getDistanceInKm()))
                .build();
    }


    private CarModel getCostByType(String type){

        switch(type) {
            case "Van":
                return new CarModel(50, 0.6); //tu robisz obiekt samochodu 10 na sto plus kwota początkowa
            case "Bus":
                return new CarModel(50, 0.65);
            case "Sedan":
                return new CarModel(50, 0.45);
            case "Sport":
                return new CarModel(100, 0.80);
            case "Limousine":
                return new CarModel(100, 1);
            case "Exotic":
                return new CarModel(300, 1.80);
            default:
                return new CarModel(1,1);
        }
    }

}
