package ee.taltech.iti0202.api.agency;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ee.taltech.iti0202.api.destinations.City;
import ee.taltech.iti0202.api.destinations.CityBuilder;
import ee.taltech.iti0202.api.provider.OnlineDataController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgency {

    private OnlineDataController dataController = new OnlineDataController();
    private List<String> cityNames = new ArrayList<>();

    public TravelAgency(List<String> cityNames, OnlineDataController dataController) {
        this.cityNames = cityNames;
        this.dataController = dataController;
    }

    /**
     * If the agency doesn't have a destination city yet, adds it to the list.
     *
     * @param city city name.
     */
    public void addCity(String city) {
        if (!cityNames.contains(city)) {
            cityNames.add(city);
        }
    }

    /**
     * Return all the cities that the agency has.
     *
     * @return list of cities
     */
    public List<String> getCityList() {
        return cityNames;
    }


    /**
     * This method tries to find a suitable city for the client to visit.
     *
     * It uses OnlineDataController, to get data for the cities.
     * After getting data about a city, SAVE IT for the duration of the cycle.
     * OpenWeather API updates data every 10 minutes.
     * Create a City object using the CityBuilder here.
     * @param client a client who wants to go somewhere.
     * @return Optional city if the client was happy with it.
     */
    public Optional<City> findSuitableCitiesForClient(Client client) {
        List<City> cities = new ArrayList<>();

        for (String city : cityNames) {
            String jsonString = dataController.getCity(city);
            JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
            String cityName = jsonObject.getAsJsonObject("city").get("name").getAsString();
            double cityLat = jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lat").getAsDouble();
            double cityLon = jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lon").getAsDouble();
            JsonArray array = jsonObject.getAsJsonArray("list");

            List<Integer> weatherCodes = new ArrayList<>();
            List<Double> temperatures = new ArrayList<>();
            List<Double> humidities = new ArrayList<>();

            for (int index = 0; index < array.size(); index++) {
                int weatherCode = array.get(index).getAsJsonObject().getAsJsonArray("weather").get(0)
                        .getAsJsonObject().get("id").getAsInt();
                double humidity = array.get(index).getAsJsonObject().getAsJsonObject("main").get("humidity")
                        .getAsDouble();
                double temperature = array.get(index).getAsJsonObject().getAsJsonObject("main").get("temp")
                        .getAsDouble();
                weatherCodes.add(weatherCode);
                temperatures.add(temperature);
                humidities.add(humidity);
            }

            CityBuilder cityBuilder = new CityBuilder();
            cityBuilder.setHumidity(humidities);
            cityBuilder.setTemperatures(temperatures);
            cityBuilder.setName(cityName);
            cityBuilder.setLat(cityLat);
            cityBuilder.setLon(cityLon);
            cityBuilder.setWeatherCodes(weatherCodes);
            cities.add(cityBuilder.createCity());
        }

        if (client.getClass().getSimpleName().equals("ChoosingClient") && client.getCitiesThatWantsToVisit()
                .isEmpty()) {
            return Optional.empty();
        }

        return client.chooseBestCity(cities);
    }

}
