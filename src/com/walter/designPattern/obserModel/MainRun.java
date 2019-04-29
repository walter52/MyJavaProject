package com.walter.designPattern.obserModel;


public class MainRun {

    public static void main(String[] args) {
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        WeatherData weatherData = new WeatherData();
        weatherData.registerObserver(currentConditionsDisplay);
        weatherData.setMeasurements("23","100","45");
    }
}