package com.example.demo.controllers;

import com.example.demo.models.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/weather")
    public String showWeather(String city, Model model) {
        String apiKey = "d107e64a83935fb95aafe7864d6e1952";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=imperial&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        model.addAttribute("weather", weatherResponse);
        model.addAttribute("city", city);


        return "weather";
    }
}
