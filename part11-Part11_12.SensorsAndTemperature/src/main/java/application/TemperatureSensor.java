/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.util.Random;

/**
 *
 * @author Am0rphic
 */
public class TemperatureSensor implements Sensor  {
    private boolean activity;
    
    public TemperatureSensor() {
        this.activity=false;
    }

    @Override
    public boolean isOn() {
        if (this.activity==true) {
            return true;
        }
        return false;
    }

    @Override
    public void setOn() {
        this.activity=true;
    }

    @Override
    public void setOff() {
        this.activity=false;
    }

    @Override
    public int read() {
        return (new Random().nextInt(61)-30);
    }
    
    
}
