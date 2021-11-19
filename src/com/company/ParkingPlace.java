package com.company;

/*Доступно несколько машиномест.
На одном месте может находиться только один автомобиль.
Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
 */

public class ParkingPlace {
    private String name;
    private boolean isOccupied;
    private PlaceStatus status=PlaceStatus.FREE;
    public ParkingPlace(String name){
        this.name=name;
        isOccupied=false;
    }

    public void Occupied(Car car) {
        isOccupied=true;
        System.out.println(car.getName()+" is occupying the "+this.name+".");
        car.takingPlaceForAllTimeOrNot();
    }

    public PlaceStatus getStatus() {
        return status;
    }

    public void isFree(Car car) {
        isOccupied=false;
        System.out.println(car.getName()+" has arrived from "+this.name+".");
        status=PlaceStatus.FREE;
    }

    public void thePlaceIsfreeOrNot(Car car) {
        System.out.println(car.getName()+" is thinking to take the "+ this.name +" for all day or not...");
        if(car.getCarStatus()==CarStatus.ARRIVED){
            System.out.println(car.getName()+" is taking "+this.name+" for some time.");
            status=PlaceStatus.TEMPORARY;
        }
        else{
            System.out.println(car.getName()+" is taking "+this.name+" for all day.");
            status=PlaceStatus.TAKEN;
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
