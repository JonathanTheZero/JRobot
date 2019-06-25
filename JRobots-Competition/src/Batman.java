import jrobots.utils.*;

import java.awt.Color;

import jrobots.*;
import jrobots.simulation.simulationObjects.JRobot2011;
import jrobots.simulation.simulationObjects.Pilot;
import jrobots.simulation.simulationObjects.launchables.Bullet;

/** A minimal functional Bot, ready for being programmed. 
 * <p>Please enter the documentation via the method <tt>actions()</tt>.
 * <p>Please rename uniquely. The individual name will be displayed in the GUI.
 * @see JRobot2015_2#actions()
 */
public class Batman extends JRobot2011 {
	private static final long serialVersionUID = 1L;
	boolean angleFound, shouldFire = false;
	Angle a = Angle.NORTH;
	int i = 0;
	int howManyRounds = 2;

	@Override
	protected void init() {
		setNameColor(Color.BLUE);
		setBodyColor(Color.LIGHT_GRAY);
		setTurretColor(Color.RED);
		setScanAperture(getMaxScanAperture());
	}
	
	
	protected void actions() {
		// TODO implement brain
		/*setScanAperture(getMaxScanAperture());
		setScanDirection(Angle.NORTH);
		boolean found = false;
		if(!getLastScan().isTargetLocated()) {
			setScanDirection(Angle.EAST);
			
			if(!getLastScan().isTargetLocated()) {
				setScanDirection(Angle.SOUTH);
				
				if(!getLastScan().isTargetLocated()) {
					
					setScanDirection(Angle.WEST);
				}
				else {
					found = true;
				}
			}
			else {
				found = true;
			}
		}
		else {
			found = true;
		}
		if(found) {
			setAutopilot(getLastScan().scanDirection, getMaxForwardVelocity());
			if(getEnergy() >= getEnergyConsumptionProjectile()) {
				setLaunchProjectileCommand(getLastScan().scanDirection);
			}
		}*/
		if(angleFound) {
			Angle f = getLastScan().scanDirection;
//			if(getLastScan().distanceToTarget <= 0.5){
////				if(getLastScan().distanceToTarget <= 0.1){
////					setAutopilot(f, 0);
////				}
////				else {
//					setAutopilot(f, getMaxForwardVelocity()/5);
////				}
//
//				shouldFire = true;
////				howManyRounds = 1;
//			}
//			else {
//				setAutopilot(f, getMaxForwardVelocity());
//				if(getLastScan().distanceToTarget >= 10){
//					setBoost();
//				}
//			}
			
			setAutopilot(f, getMaxForwardVelocity());
			
			if(getEnergyConsumptionProjectile() <= getEnergy() && shouldFire){
				setLaunchProjectileCommand(f);
			}
			
			if(getHealth() <= 0.20){
				setAutopilot(new Angle(f.getValueAsDegrees() + 180, "Degrees"), getMaxForwardVelocity());
			}
			
			
			i++;
			if(i == howManyRounds) {
//				defines after how many rounds the scan procedure should be redone
//				doing it more often costs more energy but is more precise
				shouldFire = false;
				howManyRounds = 2;
				i = 0;
				angleFound = false;
			}
		}
		else {
			setScanAperture(getMaxScanAperture());
			setScanDirection(a);
			if(getLastScan().isTargetLocated()) {
				setScanAperture(new Angle(45, "Degrees"));
				
				setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 22.5, "Degrees"));
				if(getLastScan().isTargetLocated()) {
					setScanAperture(new Angle(45/2, "Degrees"));
					setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
					
					if(getLastScan().isTargetLocated()){
						setScanAperture(new Angle(45/4, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125, "Degrees"));
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/8, "Degrees"));
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125/2, "Degrees"));
							if(getLastScan().isTargetLocated()){
								angleFound = true;
								return;
							}
							else{
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
								angleFound = true;
								return;
							}
						}
						else {
							setScanAperture(new Angle(45/8, "Degrees"));
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125/2, "Degrees"));
							if(getLastScan().isTargetLocated()){
								angleFound = true;
								return;
							}
							else{
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
								angleFound = true;
								return;
							}
						}
					}
					else {
						setScanAperture(new Angle(45/2, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10.25, "Degrees"));
						
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/4, "Degrees"));
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125, "Degrees"));
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125/2, "Degrees"));
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
									angleFound = true;
									return;
								}
							}
							else {
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125/2, "Degrees"));
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
									angleFound = true;
									return;
								}
							}
						}
					}
				}
				else {
					setScanAperture(new Angle(45, "Degrees"));
					
					setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 22.5, "Degrees"));
					if(getLastScan().isTargetLocated()) {
						setScanAperture(new Angle(45/2, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
						
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/4, "Degrees"));
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125, "Degrees"));
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125/2, "Degrees"));
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
									angleFound = true;
									return;
								}
							}
							else {
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125/2, "Degrees"));
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
									angleFound = true;
									return;
								}
							}
						}
						else {
							setScanAperture(new Angle(45/2, "Degrees"));
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10.25, "Degrees"));
							
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/4, "Degrees"));
								setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125, "Degrees"));
								if(getLastScan().isTargetLocated()){
									setScanAperture(new Angle(45/8, "Degrees"));
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125/2, "Degrees"));
									if(getLastScan().isTargetLocated()){
										angleFound = true;
										return;
									}
									else{
										setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
										angleFound = true;
										return;
									}
								}
								else {
									setScanAperture(new Angle(45/8, "Degrees"));
									setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125/2, "Degrees"));
									if(getLastScan().isTargetLocated()){
										angleFound = true;
										return;
									}
									else{
										setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 5.125, "Degrees"));
										angleFound = true;
										return;
									}
								}
							}
						}
					}
				}
			}
			else {
				a = new Angle(a.getValueAsDegrees() + 90, "Degrees");
			}
		}
		
	}
//	else {
//		setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10.25, "Degrees"));
//		if(!getLastScan().isTargetLocated()) {
//			setScanAperture(new Angle(10.25, "Degrees"));
//			setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 5.125, "Degrees"));
//			if(getLastScan().isTargetLocated()) {
//				angleFound = true;
//				return;
//			}
//			else {
//				setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10.25, "Degrees"));
//				angleFound = true;
//				return;
//			}
//		}
//	}
	
//	setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 22.5, "Degrees"));
//	if(getLastScan().isTargetLocated()){
//		setScanAperture(new Angle(45/4, "Degrees"));
//		setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25 + 10.25/2, "Degrees"));
//		angleFound = true;
//		return;
//	}
//	else {
//		setScanAperture(new Angle(45/4, "Degrees"));
//		setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25 - 10.25/2, "Degrees"));
//		angleFound = true;
//		return;
//	}
	
	protected void scanVoid(Angle a) {
		while(!angleFound) {
			setScanAperture(getMaxScanAperture());
			setScanDirection(a);
			if(getLastScan().isTargetLocated()) {
				setScanAperture(new Angle(45, "Degrees"));
				setScanDirection(new Angle(a.getValueAsDegrees() + 22.5, "Degrees"));
				if(!getLastScan().isTargetLocated()) {
					setScanDirection(new Angle(a.getValueAsDegrees() - 22.5, "Degrees"));
					if(getLastScan().isTargetLocated()) {
						setScanAperture(new Angle(22.5, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
						if(!getLastScan().isTargetLocated()) {
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10-25, "Degrees"));
							angleFound = true;
							break;
						}
						else {
							angleFound = true;
							break;// getLastScan().scanDirection;
						}
					}
				}
				else {
					if(getLastScan().isTargetLocated()) {
						setScanAperture(new Angle(22.5, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
						if(!getLastScan().isTargetLocated()) {
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10-25, "Degrees"));
							angleFound = true;
							break;// getLastScan().scanDirection;
						}
					}
					else {
						angleFound = true;
						break;// getLastScan().scanDirection;
					}
				}
			}
			else {
				a.add(new Angle(90, "Degrees"));
			}
		}
	}
	
	protected void scan(){
		setScanDirection(Angle.NORTH);
		if(getLastScan().isTargetLocated()) {
			setScanAperture(new Angle(45, "Degrees"));
			setScanDirection(new Angle(337.5, "Degrees"));
			if(!getLastScan().isTargetLocated()) {
				setScanDirection(new Angle(22.5, "Degrees"));
			}
		}
	}
	
	protected void scanAt(Angle a) {
		setScanAperture(getMaxScanAperture());
		setScanDirection(a);
		if(getLastScan().isTargetLocated()) {
			setScanAperture(new Angle(45, "Degrees"));
			setScanDirection(new Angle(a.getValueAsDegrees() + 22.5, "Degrees"));
			if(!getLastScan().isTargetLocated()) {
				setScanDirection(new Angle(a.getValueAsDegrees() - 22.5, "Degrees"));
				if(getLastScan().isTargetLocated()) {
					setScanAperture(new Angle(45/2, "Degrees"));
					setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
					if(!getLastScan().isTargetLocated()) {
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10-25, "Degrees"));
						return;
					}
					else {
						return;// getLastScan().scanDirection;
					}
				}
			}
			else {
				if(getLastScan().isTargetLocated()) {
					setScanAperture(new Angle(45/2, "Degrees"));
					setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
					if(!getLastScan().isTargetLocated()) {
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10-25, "Degrees"));
						return;// getLastScan().scanDirection;
					}
				}
				else {
					return;// getLastScan().scanDirection;
				}
			}
		}
		else {
			scanAt(a.add(new Angle(90, "Degrees")));
		}
	}
	
	public Angle scanDirection() {
		return new Angle(172, "Degrees");
	}

}
