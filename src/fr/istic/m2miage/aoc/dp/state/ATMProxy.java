package fr.istic.m2miage.aoc.dp.state;

public class ATMProxy implements GetATMData{
	// Allows the user to access getATMState in the
	// Object ATMMachine

	public ATMState getATMState() {

		ATMMachine realATMMachine = new ATMMachine();

		return realATMMachine.getATMState();
	}

	// Allows the user to access getCashInMachine
	// in the Object ATMMachine

	public int getCashInMachine() {

		ATMMachine realATMMachine = new ATMMachine();

		return realATMMachine.getCashInMachine();

	}
}
