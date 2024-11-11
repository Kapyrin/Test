package kapyrin.test.weather.controller;

import kapyrin.test.weather.service.WeatherService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
@Value("${chrome.address}")
private String chromeAddress;
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    @ResponseBody
    public String getWeather() {
        String weatherInfo = weatherService.getWeather("Moscow");
        openBrowserWithWeatherPage(weatherInfo);
        return weatherInfo;
    }

    private void openBrowserWithWeatherPage(String weatherInfo) {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeAddress);
        WebDriver driver = new ChromeDriver(options);
        driver.get("data:text/html;charset=utf-8," + weatherInfo);

        try {
            Thread.sleep(5000); // Ожидание 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}