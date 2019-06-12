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
		setLaunchProjectileCommand(Angle.EAST, 200);
	}

}
