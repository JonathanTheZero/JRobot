import jrobots.utils.*;
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
	protected void actions() {
		// TODO implement brain
		new Pilot();
		while(true) {
			Angle angle1 = Angle.EAST;
			new Scan(Angle.EAST, Angle.NORTH, 2.0, new Vector(3, 3), 3.0);
		}
	}

}
