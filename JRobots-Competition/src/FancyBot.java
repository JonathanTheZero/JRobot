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
public class FancyBot extends JRobot2011 {
	private static final long serialVersionUID = 1L;

	@Override
	protected void init() {
		setNameColor(Color.YELLOW);
		setBodyColor(Color.PINK);
		setTurretColor(Color.PINK);
	}
	
	
	protected void actions() {
		// TODO implement brain
		/*double d = Math.random() * 4.1;
		if(d < 1){
			setAutopilot(Angle.NORTH, getMaxForwardVelocity());
		}
		else if(d < 2 && d > 1){
			setAutopilot(Angle.EAST, getMaxForwardVelocity());
		}
		else if(d < 3 && d > 2){
			setAutopilot(Angle.SOUTH, getMaxForwardVelocity());
		}
		else{
			setAutopilot(Angle.WEST, getMaxForwardVelocity());
		}
		setAutopilot(Angle.WEST, getMaxForwardVelocity());
		
		if(getVelocity().getLength() == getMaxForwardVelocity()){
			setLaunchProjectileCommand(Angle.EAST, 200);
		}*/
		//scan();
		setAutopilot(Angle.NORTH, getMaxForwardVelocity());
		//if (energy>= gerEnegeryConsumptionScan()) {
			//scan();}
		//}
		
	}
	
	protected void scan(){
		
		setScanDirection(90);
		
		//if (energy >= getEnergyConsumptionMine()) {
			setDropMineCommand(true);
			
		//}
	}

}
