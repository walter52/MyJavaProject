package com.walter.obserModel2;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by walter on 2018/3/20.
 */
public class CurrentDisplay implements Observer{

    private Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPresssure();
            display();
        }
    }

    public void display(){
        System.out.println("temperature:"+temperature+",humidity:"+humidity+",pressure:"+pressure);
    }
}
