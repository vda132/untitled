package com.company;

import java.util.Random;

public class Car implements Runnable{
    private String name;
    private CarStatus status=CarStatus.WAIT;
    private Parking parking;
    public Car(String name, Parking parking){
        this.name=name;
        this.parking=parking;
    }

    public CarStatus getCarStatus(){
        return status;
    }

    public String getName() {
        return name;
    }

    public void takingPlaceForAllTimeOrNot(){
        status=CarStatus.STAYED;
        status=getRandomDecision();
    }

    private CarStatus getRandomDecision() {
        Random randDecision=new Random();
        switch(randDecision.nextInt(2)){
            case 0->status=CarStatus.STAYED;
            case 1->status=CarStatus.ARRIVED;
        }
        return status;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " start to process.");
        try {
            parking.process(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
