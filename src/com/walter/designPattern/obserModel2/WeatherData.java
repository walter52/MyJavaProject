package com.walter.designPattern.obserModel2;

import java.util.Observable;

/**
 * 利用Java内置实现
 * Created by walter on 2018/3/20.
 */
public class WeatherData extends Observable{
    private String temperture;
    private String pressure;

    public void updateInfo(String temperture,String pressure){
        this.temperture = temperture;
        this.pressure = pressure;
        setChanged();
        notifyObservers();
    }

    public String getTemperture() {
        return temperture;
    }

    public void setTemperture(String temperture) {
        this.temperture = temperture;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
