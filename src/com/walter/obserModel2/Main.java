package com.walter.obserModel2;

/**
 * Created by walter on 2018/3/20.
 */
public class Main {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        weatherData.updateData(10,12,13);
        weatherData.updateData(11,22,33);
    }
}
