package dsieradzki.pl.travelcost.controller;

import dsieradzki.pl.travelcost.model.CostModel;
import dsieradzki.pl.travelcost.model.DistanceModel;
import dsieradzki.pl.travelcost.service.CalculateService;
import dsieradzki.pl.travelcost.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class DistanceController {

    private final DistanceService distanceService;
    private final CalculateService calculateService;

    @GetMapping("/distance")
    public DistanceModel getDistanceBetweenTwoCity(@RequestParam String start,@RequestParam String end) throws Exception {
        return distanceService.getCoordinates(start, end);

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/cost")
    public CostModel getCost(@RequestParam String start, @RequestParam String end, @RequestParam String type) throws Exception {
        return calculateService.travelCost(start, end, type);
    }

}
