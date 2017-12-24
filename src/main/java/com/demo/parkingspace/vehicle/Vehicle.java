/**
 * 
 */
package com.demo.parkingspace.vehicle;

/**
 * @author IZANAGI
 *
 */
public class Vehicle {
    private int wheels;
    private String brand;

    public Vehicle(int numOfWheels) {
	setWheels(numOfWheels);
	// setBrand(brand);
    }

    /**
     * @return the wheels
     */
    public int getWheels() {
	return wheels;
    }

    /**
     * @param wheels
     *            the wheels to set
     */
    public void setWheels(int wheels) {
	this.wheels = wheels;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
	return brand;
    }

    /**
     * @param brand
     *            the brand to set
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }
}