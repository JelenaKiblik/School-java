package ee.taltech.iti0202.api.strategies;
import ee.taltech.iti0202.api.destinations.City;

import java.util.List;
import java.util.Optional;

public interface CityFinderStrategy {
    Optional<City> findBestCity(List<City> candidateCities);
}

