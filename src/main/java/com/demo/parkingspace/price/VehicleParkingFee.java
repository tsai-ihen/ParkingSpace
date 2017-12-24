/**
 * 
 */
package com.demo.parkingspace.price;

/**
 * @author IZANAGI
 *
 */
public class VehicleParkingFee {

	private double parkingFee;

	public VehicleParkingFee(int wheels) {
		if (wheels == 2) {
			setParkingFee(20);
		} else if (wheels == 4) {
			setParkingFee(40);
		}
	}

	/**
	 * @return the parkingFee
	 */
	public double getParkingFee() {
		return parkingFee;
	}

	/**
	 * @param parkingFee
	 *            the parkingFee to set
	 */
	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
}
