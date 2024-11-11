package kapyrin.test.weather.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private String currentWeather = "";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather(String city) {
        String weatherUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;
        try {
            String result = restTemplate.getForObject(weatherUrl, String.class);
            JSONObject jsonObject = new JSONObject(result);
            JSONObject current = jsonObject.getJSONObject("current");
            double tempC = current.getDouble("temp_c");
            String condition = current.getJSONObject("condition").getString("text");
            currentWeather = "Сейчас в " + city + " температура воздуха " + tempC + " градусов и " + condition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentWeather;
    }
}
