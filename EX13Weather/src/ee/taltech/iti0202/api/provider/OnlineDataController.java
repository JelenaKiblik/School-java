package ee.taltech.iti0202.api.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OnlineDataController {

    /**
     * Tries to get forecast data for the cityName. If there is no data or cityName doesn't exist,
     * return an empty string.
     *
     * @param cityName Name of the city
     * @return String in the form of a json-string
     */
    public String getCity(String cityName) {

        final int TIME_OUT = 5000;
        final int OK = 299;
        StringBuffer responseContent = new StringBuffer();
        String modifiedCityName = cityName.replaceAll(" ", "+");
        BufferedReader reader;
        String line;

        try {
            URL url = new URL(String.format("https://api.openweathermap.org/data/2.5/forecast"
                    + "?q=%s&units=metric&APPID=319dafe50c462c4072689e969afc2529", modifiedCityName));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIME_OUT);
            connection.setReadTimeout(TIME_OUT);
            int status = connection.getResponseCode();
            if (status > OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseContent.toString();
    }
}

