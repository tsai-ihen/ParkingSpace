/**
 * 
 */
package com.demo.parkingspace.vehicle;

import com.demo.parkingspace.price.VehicleParkingFee;

/**
 * @author IZANAGI
 *
 */
public class Car {

	private Vehicle				theCar;
	private VehicleParkingFee	theFee;

	public Car(int wheels) {
		this.theCar = new Vehicle(wheels);
		this.theFee = new VehicleParkingFee(wheels);
		System.out.println("Car Created: " + this.getTheCar().getWheels() + " wheels, parking fee @ "
				+ this.getTheFee().getParkingFee() + "/hr");
	}

	/**
	 * @return the theCar
	 */
	protected Vehicle getTheCar() {
		return theCar;
	}

	/**
	 * @param theCar
	 *            the theCar to set
	 */
	protected void setTheCar(Vehicle theCar) {
		this.theCar = theCar;
	}

	/**
	 * @return the theFee
	 */
	protected VehicleParkingFee getTheFee() {
		return theFee;
	}

	/**
	 * @param theFee
	 *            the theFee to set
	 */
	protected void setTheFee(VehicleParkingFee theFee) {
		this.theFee = theFee;
	}

}
