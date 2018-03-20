package com.walter.obserModel2;

import java.util.Observable;

/**
 * 利用Java内置实现
 * Created by walter on 2018/3/20.
 */
public class WeatherData extends Observable{
    private float temperature;
    private float humidity;
    private float presssure;

    public WeatherData(){
    }

    public void updateData(float temperature,float humidity,float presssure){
        this.temperature = temperature;
        this.presssure = presssure;
        this.humidity = humidity;

        this.setChanged();
        this.notifyObservers();
    }


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPresssure() {
        return presssure;
    }

    public void setPresssure(float presssure) {
        this.presssure = presssure;
    }
}
