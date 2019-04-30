package com.walter.designpattern.obserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walter on 2018/1/9.
 */
public class WeatherData implements Subject {
    private List<Observer> observers;
    private String temperature;
    private String humidity;
    private String pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("register observer");
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
        System.out.println("remove observer");
    }

    @Override
    public void notifyOvserver() {
        System.out.println("notify observer");
        for(Observer observer:observers){
            observer.update(temperature, humidity, pressure);
        }
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void measurementsChanged() {
        notifyOvserver();
    }

    public void setMeasurements(String temperature,String humidity,String pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
