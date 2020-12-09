/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors.*;
import java.util.stream.Collectors;
import java.util.Collections;
/**
 *
 * @author Am0rphic
 */
public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readingList = new ArrayList<>(); //30 mins spent fixing read() when this wants instantiated ....
    
    public AverageSensor() {
        this.sensors= new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    
    //think about using stream to implement it? - probably not efficient
    @Override
    public boolean isOn() {
        return sensors.stream().allMatch(s -> s.isOn()==true);
        
//        for (Sensor s:sensors) {
//            if (s.isOn()==false) {
//                return false;
//            }
//        }
//        return true;
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(s -> s.setOn());
    }

    @Override
    public void setOff() {
        sensors.stream().forEach(s -> s.setOff());
    }

    @Override
    public int read() {
        if (this.isOn() == true) {
            int reading = (int) sensors.stream().mapToInt(s -> s.read()).average().getAsDouble();
            readingList.add(reading);
            return reading;
        }
        throw new IllegalStateException("Not all sensors are on!");
    }
    
    public List<Integer> readings() {
//        List list = sensors.stream()
//                .map(s -> s.read())  // 30 mins spent trying with mapToInt
//                .collect(Collectors.toList());
//        System.out.println(list);
//        return list;
        System.out.println(readingList);
        return this.readingList;
    }
}
