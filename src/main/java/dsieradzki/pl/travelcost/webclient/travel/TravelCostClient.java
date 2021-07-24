package dsieradzki.pl.travelcost.webclient.travel;

import dsieradzki.pl.travelcost.model.DistanceModel;
import dsieradzki.pl.travelcost.webclient.travel.dto.DistanceDto.Root;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TravelCostClient {

    private final String GEOCODE = "https://maps.googleapis.com/maps/api/distancematrix/";
    private final String API_KEY = "API_KEY";

    private RestTemplate restTemplate = new RestTemplate();

    public DistanceModel getCoordinatesForCity(String origin, String destination) throws Exception {
        Root root = callGetMethod("json?units=metric&origins={origin}&destinations={destination}&key={apiKey}",
                Root.class, origin, destination, API_KEY);

        return DistanceModel.builder()
                .value(root.getRows()[0].getElements()[0].getDistance().getValue())
                .build();

    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(GEOCODE + url,
                responseType, objects);
    }



}
