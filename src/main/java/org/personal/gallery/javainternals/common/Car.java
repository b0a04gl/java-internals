package org.personal.gallery.javainternals.common;


public class Car {
    private  String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }
}
