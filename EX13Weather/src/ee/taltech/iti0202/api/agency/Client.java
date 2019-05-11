package ee.taltech.iti0202.api.agency;

import ee.taltech.iti0202.api.destinations.City;
import ee.taltech.iti0202.api.strategies.CityFinderStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Client {

    private final String name;
    private final String startingCity;
    private final CityFinderStrategy choosingStrategy;
    private List<String> wantsToVisitCities = new ArrayList<>();

    public Client(String name, String startingCity, CityFinderStrategy choosingStrategy) {
        this.name = name;
        this.startingCity = startingCity;
        this.choosingStrategy = choosingStrategy;
    }

    public Client(String name, String startingCity, CityFinderStrategy choosingStrategy,
                  List<String> wantsToVisitCities) {
        this.name = name;
        this.startingCity = startingCity;
        this.choosingStrategy = choosingStrategy;
        this.wantsToVisitCities = wantsToVisitCities;
    }

    public String getName() {
        return name;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public CityFinderStrategy getChoosingStrategy() {
        return choosingStrategy;
    }

    public List<String> getCitiesThatWantsToVisit() {
        return wantsToVisitCities;
    }

    public Optional<City> chooseBestCity(List<City> possibleCities) {
        List<City> viableCities = possibleCities.stream()
                .filter(city -> !city.getName().equals(startingCity))
                .collect(Collectors.toList());
        List<City> listWithPreferredCities = new ArrayList<>();
        List<City> listWithNormalCities = new ArrayList<>();
        for (City city : viableCities) {
            if (wantsToVisitCities.contains(city.getName())) {
                listWithPreferredCities.add(city);
            } else {
                listWithNormalCities.add(city);
            }
        }
        if (listWithPreferredCities.isEmpty()) {
            return choosingStrategy.findBestCity(listWithNormalCities);
        } else {
            return choosingStrategy.findBestCity(listWithPreferredCities);
        }
    }
}
