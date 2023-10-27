package org.personal.gallery.javainternals.common;


public final class ImmutableCar {
    private final String model;
    private final String brand;

    public ImmutableCar(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "ImmutableCar{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
