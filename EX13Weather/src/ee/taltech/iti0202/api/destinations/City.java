package ee.taltech.iti0202.api.destinations;

import java.util.List;

public class City {

    private final String name;
    private final double lon;
    private final double lat;
    private final List<Double> temperatures;
    private final List<Double> humidity;
    private final List<Integer> weatherCodes;

    City(String name, double lon, double lat, List<Double> temperatures, List<Double> humidity,
         List<Integer> weatherCodes) {
        this.name = name;
        this.lon = lon;
        this.lat = lat;
        this.temperatures = temperatures;
        this.humidity = humidity;
        this.weatherCodes = weatherCodes;
    }

    public String getName() {
        return name;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public List<Integer> getWeatherCodes() {
        return weatherCodes;
    }

    public double getAverageTemperature() {
        return temperatures.stream()
                .mapToDouble(val -> val)
                .average()
                .getAsDouble();
    }


    public double getAverageHumidity() {
        return humidity.stream()
                .mapToDouble(val -> val)
                .average()
                .getAsDouble();
    }

}
