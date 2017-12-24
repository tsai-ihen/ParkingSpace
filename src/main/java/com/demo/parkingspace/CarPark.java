/**
 * 
 */
package com.demo.parkingspace;

import java.util.Locale;

import com.demo.parkingspace.incoming.IncomingVehicleGenerator;
import com.demo.parkingspace.outgoing.OutgoingVehicleConsumer;

/**
 * @author IZANAGI
 *
 */
enum Commands {
	QUIT, GENVEHICLE, STOPGEN, VEHICLELEAVE;

	// private String cmd;
	//
	// Commands(String cmd) {
	// this.cmd = cmd;
	// }
}

enum VehicleType {
	BICYCLE(2), SCOOTER(2), MOTORBIKE(2), CAR(2), BUS(6), TRUCK(6);

	VehicleType(int wheels) {

	}
}

public class CarPark {

	private static boolean active = true;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// while (active) {

		// Parse arguments for things to do
		if (args.length == 0) {
			// Print commands upon starting with no args
			System.out.println("<<------Dummy Car Park Demo----->>\n" + "Arguments:\n" + " genvehicle=x" + "\t\t" + "Starts a thread generating incoming vehicles of type x: "
					+ "\n" + "\t\t\t" + "bicycle, scooter, motorbike, car, bus, truck\n" + " vehicleleave=x" + "\t\t"
					+ "Creates a thread to pick outgoing vehicles every x seconds\n" + " quit" + "\t\t" + "Ends this demo\n");

		} else if (args.length > 0) {
			// Try to parse and exec commands from args
			for (String arg : args) {
				String[] command = arg.split("=");
				Commands cmd = Commands.valueOf(command[0].toUpperCase(Locale.ENGLISH));
				execCommand(cmd, command[1]);
			}
		}
		// }
	}

	/**
	 * @param args
	 */
	private static void execCommand(Commands cmd, String val) {
		switch (cmd) {
			case QUIT:
				System.out.println("Shutting down demo...");
				System.out.println("Demo has completed !");

				break;

			case GENVEHICLE:
				System.out.println("Generating cars with " + val + " wheels.");
				int wheels = Integer.valueOf(val);
				IncomingVehicleGenerator carGen = new IncomingVehicleGenerator("Car", wheels);
				carGen.start();

				break;
			case STOPGEN:
				break;

			case VEHICLELEAVE:
				System.out.println("Cars are leaving...");
				OutgoingVehicleConsumer carLeave = new OutgoingVehicleConsumer("Leave");
				carLeave.start();

				break;
		}
	}
}
