/**
 * 
 */
package com.demo.parkingspace.incoming;

import java.util.ArrayList;

import com.demo.parkingspace.vehicle.Car;

/**
 * @author IZANAGI
 *
 */

public class IncomingVehicleGenerator implements Runnable {
	private Thread					t;
	private String					threadName;
	private boolean					running			= true;

	private static ArrayList<Car>	incomingCars	= new ArrayList<Car>();

	public IncomingVehicleGenerator() {

	}

	public IncomingVehicleGenerator(String name, int wheels) {
		setThreadName(name);
		System.out.println("Creating " + getThreadName() + " Incoming Vehicle Generator");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running " + getThreadName());
		while (running) {

			try {
				Car incomingVehicle = new Car(4);
				incomingCars.add(incomingVehicle);
				t.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + getThreadName() + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + getThreadName());
		if (t == null) {
			t = new Thread(this, getThreadName());
			t.start();
		}
	}

	public void stop() {
		setRunning(false);
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	/**
	 * @return the running
	 */
	protected boolean isRunning() {
		return running;
	}

	/**
	 * @param running
	 *            the running to set
	 */
	protected void setRunning(boolean running) {
		this.running = running;
	}

	public static ArrayList<Car> getIncomingCars() {
		return incomingCars;
	}

}
