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
public class NichtEmptyBot extends JRobot2011 {
	private static final long serialVersionUID = 1L;
	int distance, angle = 0;
	Angle angle1 = new Angle(0.00, "Degrees");

	@Override
	protected void init() {
		setNameColor(Color.BLUE);
		setBodyColor(Color.LIGHT_GRAY);
		setTurretColor(Color.RED);
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
		setScanAperture(getMaxScanAperture());
		setScanDirection(angle1);
		while(getLastScan().distanceToTarget == 0) {
			angle++;
			angle1 = new Angle(angle, "Degrees");
		}
		setLaunchProjectileCommand(angle1);
		setAutopilot(angle1, getMaxForwardVelocity());
		//scan();
		
	}
	
	protected void scan(){
		setScanAperture(getMaxScanAperture());
		setScanDirection(Angle.NORTH);
		if(!getLastScan().isTargetLocated()) {
			setScanDirection(Angle.EAST);
			
			if(!getLastScan().isTargetLocated()) {
				setScanDirection(Angle.SOUTH);
				
				if(!getLastScan().isTargetLocated()) {
					
					setScanDirection(Angle.WEST);
				}
			}
		}
		setAutopilot(getLastScan().scanDirection, getMaxForwardVelocity());
	}
	
	public Angle scanDirection() {
		return new Angle(172, "Degrees");
	}

}
