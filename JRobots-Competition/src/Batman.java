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
	int distance, angle = 0;
	Angle angle1 = new Angle(0.00, "Degrees");
	boolean angleFound = false;
	Angle a = Angle.NORTH;

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
			setAutopilot(getLastScan().scanDirection, 100);
		}
		else {
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
							angleFound = true;
							return;
						}
						else {
							angleFound = true;
							return;
						}
					}
				}
				else {
					if(getLastScan().isTargetLocated()) {
						setScanAperture(new Angle(45/2, "Degrees"));
						setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() + 10.25, "Degrees"));
						if(!getLastScan().isTargetLocated()) {
							setScanDirection(new Angle(getLastScan().scanDirection.getValueAsDegrees() - 10-25, "Degrees"));
							angleFound = true;
							return;
						}
					}
					else {
						angleFound = true;
						return;
					}
				}
			}
			else {
				a.add(new Angle(90, "Degrees"));
			}
		}
		//scanAt(Angle.NORTH);
		scanVoid(Angle.NORTH);
		//scan();
		
	}
	
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
						setScanAperture(new Angle(45/2, "Degrees"));
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
						setScanAperture(new Angle(45/2, "Degrees"));
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
