package com.walter.designPattern.obserModel2;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by walter on 2018/3/20.
 */
public class CurrentDisplay implements Observer{
    private Observable observable;
    private String temperture;
    private String pressure;

    public CurrentDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            temperture = weatherData.getTemperture();
            pressure = weatherData.getPressure();
            System.out.println("temperture"+temperture+",pressure"+pressure);
        }
    }
}
