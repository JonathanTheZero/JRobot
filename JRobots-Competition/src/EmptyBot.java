import jrobots.utils.*;

import java.awt.Color;

import jrobots.*;
import jrobots.simulation.simulationObjects.JRobot2015_2;
import jrobots.simulation.simulationObjects.Pilot;
import jrobots.simulation.simulationObjects.launchables.Bullet;

/** A minimal functional Bot, ready for being programmed. 
 * <p>Please enter the documentation via the method <tt>actions()</tt>.
 * <p>Please rename uniquely. The individual name will be displayed in the GUI.
 * @see JRobot2015_2#actions()
 */
public class EmptyBot extends JRobot2015_2 {
	private static final long serialVersionUID = 1L;

	@Override
	protected void init() {
		setNameColor(Color.BLUE);
		setBodyColor(Color.LIGHT_GRAY);
		setTurretColor(Color.RED);
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
		}*/
		setAutopilot(Angle.WEST, getMaxForwardVelocity());
		
		if(getVelocity().getLength() == getMaxForwardVelocity()){
			setLaunchProjectileCommand(Angle.EAST, 200);
		}
		//scan();
		
	}
	
	protected void scan(){
		setSonarEnergy(0.01);
	}

}
