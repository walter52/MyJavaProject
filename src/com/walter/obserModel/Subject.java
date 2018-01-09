package com.walter.obserModel;

/**
 * Created by walter on 2018/1/9.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyOvserver();
}
