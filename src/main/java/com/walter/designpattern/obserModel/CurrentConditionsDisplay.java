package com.walter.designpattern.obserModel;

/**
 * Created by walter on 2018/1/9.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement{
    private String temp;
    private String humidity;
    private String pressure;
    @Override
    public void update(String temp, String humidity, String pressure) {
        System.out.println("start update");
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
       display();
    }

    @Override
    public void display() {
        System.out.println("current display,temp:"+temp+",humidity:"+humidity+",pressure:"+pressure);
    }
}
