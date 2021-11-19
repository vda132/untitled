package com.company;

/*Доступно несколько машиномест.
На одном месте может находиться только один автомобиль.
Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
 */

import java.util.List;

public class Parking {
    private List<ParkingPlace> parkingPlaces;
    Parking(List<ParkingPlace> parkingPlaces){
        this.parkingPlaces=parkingPlaces;
    }

    private ParkingPlace findFreePlaceOrNull(){
        for(var parkingPlace:parkingPlaces){
            if(!parkingPlace.isOccupied()){
                return parkingPlace;
            }
        }
        return null;
    }

    public synchronized void process(Car car) throws InterruptedException {
        ParkingPlace freePlace;
        int time=0;
        while ((freePlace=findFreePlaceOrNull()) == null) {
                System.out.println(car.getName()+" is waiting.");
                time+=500;
                wait(500);
                if(time>2000){
                    wait(100);
                    System.out.println(car.getName()+" is going away due to long waiting.");
                    break;
                }
        }
        if (freePlace != null) {
            freePlace.Occupied(car);
            wait(700);
            freePlace.thePlaceIsfreeOrNot(car);
            if (freePlace.getStatus()==PlaceStatus.TEMPORARY) {
                wait(1000);
                freePlace.isFree(car);
            }
        }
        notify();
    }
}

