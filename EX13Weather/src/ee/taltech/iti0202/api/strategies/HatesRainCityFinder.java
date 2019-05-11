package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HatesRainCityFinder implements CityFinderStrategy {
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {
        final int RAIN_NUMBER_START = 500;
        final int RAIN_NUMBER_END = 531;
        final int HIGHEST_ALLOWED_HUMIDITY = 80;
        final int MAX_ALLOWED_RAIN = 8;
        List<City> notRaining = new ArrayList<>();
        for (City city : candidateCities) {
            int hasRained = 0;
            for (Integer weatherCode : city.getWeatherCodes()) {
                if (weatherCode >= RAIN_NUMBER_START && weatherCode <= RAIN_NUMBER_END) {
                    hasRained++;
                }
            }
            if (hasRained <= MAX_ALLOWED_RAIN) notRaining.add(city);
        }
        List<City> lowHumidity = notRaining.stream()
                .filter(city -> city.getAverageHumidity() <= HIGHEST_ALLOWED_HUMIDITY)
                .collect(Collectors.toList());
        if (lowHumidity.isEmpty()) {
            return Optional.empty();
        } else {
            return lowHumidity.stream()
                    .min(Comparator.comparing(City::getAverageHumidity));
        }
    }
}
