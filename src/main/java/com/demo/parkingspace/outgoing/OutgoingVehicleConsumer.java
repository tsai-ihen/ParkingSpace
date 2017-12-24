/**
 * 
 */
package com.demo.parkingspace.outgoing;

import java.util.ArrayList;

import com.demo.parkingspace.incoming.IncomingVehicleGenerator;
import com.demo.parkingspace.vehicle.Car;

/**
 * @author IZANAGI
 *
 */
public class OutgoingVehicleConsumer implements Runnable {
	private Thread			t;
	private String			threadName;
	private boolean			running			= true;
	private int				parkedCars		= 0;

	// private IncomingVehicleGenerator carQueue = new IncomingVehicleGenerator();

	private ArrayList<Car>	outgoingCars	= new ArrayList<Car>();

	public OutgoingVehicleConsumer() {

	}

	public OutgoingVehicleConsumer(String name) {
		setThreadName(name);
		System.out.println("Creating " + getThreadName() + " Outgoing Vehicle Consumer");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running " + getThreadName());
		while (running) {

			try {
				setParkedCars(IncomingVehicleGenerator.getIncomingCars().size());
				System.out.println("Parked cars: " + parkedCars);
				t.sleep(4000);
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

	public int getParkedCars() {
		return parkedCars;
	}

	public void setParkedCars(int parkedCars) {
		this.parkedCars = parkedCars;
	}

	public ArrayList<Car> getOutgoingCars() {
		return outgoingCars;
	}

}
