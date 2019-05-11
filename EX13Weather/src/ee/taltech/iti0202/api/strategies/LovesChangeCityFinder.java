package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LovesChangeCityFinder implements CityFinderStrategy  {
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {
        Map<City, Integer> scoreMap = new HashMap<>();
        final int ONE_HUNDRED = 100;
        final int TWENTY = 20;
        final int TEN = 10;

        for (City city : candidateCities) {
            double temperatureAverage = city.getAverageTemperature();
            double humidityAverage = city.getAverageHumidity();
            double score = 0;

            for (int index = 0; index < city.getWeatherCodes().size(); index++) {
                if (index == city.getWeatherCodes().size() - 1) {
                    break;
                }

                int currentCode = city.getWeatherCodes().get(index);
                int nextCode = city.getWeatherCodes().get(index + 1);

                if (nextCode == currentCode) {
                    score -= TEN;
                } else if (!Integer.toString(currentCode).substring(0, 1)
                        .equals(Integer.toString(nextCode).substring(0, 1))) {
                    score += ONE_HUNDRED;
                } else {
                    score += TWENTY;
                }
            }

            for (int i = 0; i < city.getTemperatures().size(); i++) {
                double currentTemp = city.getTemperatures().get(i);
                double currentHum = city.getHumidity().get(i);
                score += Math.abs(temperatureAverage - currentTemp) + Math.abs(humidityAverage - currentHum);
            }

            scoreMap.put(city, (int) score);
        }

        return Optional.of(Objects.requireNonNull(scoreMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null))
                .getKey());
    }
}
