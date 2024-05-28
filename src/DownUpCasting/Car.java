package DownUpCasting;

import DownUpCasting.Vechicle;

class Car extends Vechicle { //subclasa
    void drive() {
        System.out.println("Driving a Car...");
    }

    void speedUp() {
        System.out.println("Speeding up Car...");
    }
}
