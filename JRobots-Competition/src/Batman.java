import jrobots.utils.*;

import java.awt.Color;

import com.sun.xml.internal.ws.api.pipe.NextAction;

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
	boolean firstRound = false;
	Angle lastScan;

	@Override
	protected void init() {
		setNameColor(Color.BLUE);
		setBodyColor(Color.LIGHT_GRAY);
		setTurretColor(Color.RED);
		setScanAperture(getMaxScanAperture());
	}
	
	
	protected void actions() {
//		setScanDirection(Angle.NORTH);
//		System.out.println(getLastScan().scanDirection);
		// TODO implement brain
		if(angleFound) {
//			Angle f = lastScan;
			//System.out.println(f);
			System.out.println("LAST SCAN FFFFFFFFFFFFFFFFFF:" + lastScan);
			Angle f = new Angle(lastScan.getValueAsDegrees() - 105, "Degrees");
			setAutopilot(f, getMaxForwardVelocity());
			setLaunchProjectileCommand(f);
////			checking health
//			if(getHealth() <= 0.2){
//				setAutopilot(new Angle(f.getValueAsDegrees() + 180, "Degrees"), getMaxForwardVelocity());
//				if(getEnergyConsumptionMine() <= getEnergy()) {
//					setDropMineCommand(true);
//					howManyRounds = 10;
//				}
//
//			}
//			else {
//				
//			}
//			
////			sw distance to target
//			if(getLastScan().distanceToTarget <= 3 && getLastScan().distanceToTarget != 0){
//				if(getLastScan().distanceToTarget <= 0.1){
//					setAutopilot(f, 0);
//				}
//				else {
//					setAutopilot(f, getMaxForwardVelocity()/5);
//				}
//				shouldFire = true;
//				howManyRounds = 1;
//			}
//			else{
//				setAutopilot(f, getMaxForwardVelocity());
//			}
//			shouldFire = true;
//			
////			checking if projectile should be launched
//			if(getEnergyConsumptionProjectile() <= getEnergy() && shouldFire){
//				setLaunchProjectileCommand(f);
////				setScanAperture(new Angle(45/8, "Degrees"));
////				setScanDirection(f);
////				if(getLastScan().isTargetLocated()) {
////					if(getEnergyConsumptionProjectile() <= getEnergy() && shouldFire){
////						setLaunchProjectileCommand(f);
////					}
////				}
//			}
//				
//			Round reset
			i++;
			if(i >= 1) {
//				defines after how many rounds the scan procedure should be redone
//				doing it more often costs more energy but is more precise
				shouldFire = false;
				howManyRounds = 2;
				i = 0;
				angleFound = false;
				a = Angle.NORTH;
			}
		}
		else {
//			if(i < 10 && firstRound){
//				i++;
//				return;
//			}
//			firstRound = false;
//			i = 0;
			setScanAperture(getMaxScanAperture());
			setScanDirection(a);
			Angle saveA = new Angle(a.getValueAsDegrees(), "Degrees");
			lastScan=new Angle(a.getValueAsDegrees(), "Degrees");
			double save = a.getValueAsDegrees();
			System.out.println("0" + getLastScan().scanDirection.getValueAsDegrees());
			if(getLastScan().isTargetLocated()) {
				setScanAperture(new Angle(45, "Degrees"));
				
				setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5, "Degrees"));
				lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5, "Degrees");
				System.out.println("1TEST"+ lastScan.getValueAsDegrees());
				if(getLastScan().isTargetLocated()) {
					setScanAperture(new Angle(45/2, "Degrees"));
					setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/2, "Degrees"));
					lastScan=new Angle(lastScan.getValueAsDegrees() + 22.5/2, "Degrees");
					System.out.println("2TEST"+ lastScan.getValueAsDegrees());
					
					if(getLastScan().isTargetLocated()){
						setScanAperture(new Angle(45/4, "Degrees"));
						setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees"));
						lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees");
						System.out.println("3TEST"+ getLastScan().scanDirection.getValueAsDegrees() + "lastSCan:" + lastScan.getValueAsDegrees());
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/8, "Degrees"));
							setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
							lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
							System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
							if(getLastScan().isTargetLocated()){
								angleFound = true;
								return;
							}
							else{
								setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
								lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
								System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
								angleFound = true;
								return;
							}
						}
						else {
							setScanAperture(new Angle(45/8, "Degrees"));
							setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
							lastScan=new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
							System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
							if(getLastScan().isTargetLocated()){
								angleFound = true;
								return;
							}
							else{
								lastScan = new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
								setScanDirection(lastScan);
								System.out.println("5TEST"+ lastScan.getValueAsDegrees());
								angleFound = true;
								return;
							}
						}
					}
					else {
						setScanAperture(new Angle(45/2, "Degrees"));
						setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/2, "Degrees"));
						lastScan = new Angle(lastScan.getValueAsDegrees() - 22.5/2, "Degrees");
						System.out.println("2"+ getLastScan().scanDirection.getValueAsDegrees());
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/4, "Degrees"));
							setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees"));
							lastScan= new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
							System.out.println("3"+ getLastScan().scanDirection.getValueAsDegrees());
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
								lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/8, "Degrees");
								System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
									lastScan= new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
									System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
									angleFound = true;
									return;
								}
							}
							else {
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
								lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
								System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
									lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
									System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
									angleFound = true;
									return;
								}
							}
						}
					}
				}
				else {
					setScanAperture(new Angle(45, "Degrees"));
					
					setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5, "Degrees"));
					lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5, "Degrees");
					System.out.println("1TEST"+ lastScan.getValueAsDegrees());
					if(getLastScan().isTargetLocated()) {
						setScanAperture(new Angle(45/2, "Degrees"));
						setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/2, "Degrees"));
						lastScan=new Angle(lastScan.getValueAsDegrees() + 22.5/2, "Degrees");
						System.out.println("2TEST"+ lastScan.getValueAsDegrees());
						
						if(getLastScan().isTargetLocated()){
							setScanAperture(new Angle(45/4, "Degrees"));
							setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees"));
							lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees");
							System.out.println("3TEST"+ getLastScan().scanDirection.getValueAsDegrees() + "lastSCan:" + lastScan.getValueAsDegrees());
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
								lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
								System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
									lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
									System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
									angleFound = true;
									return;
								}
							}
							else {
								setScanAperture(new Angle(45/8, "Degrees"));
								setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
								lastScan=new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
								System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
								if(getLastScan().isTargetLocated()){
									angleFound = true;
									return;
								}
								else{
									lastScan = new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
									setScanDirection(lastScan);
									System.out.println("5TEST"+ lastScan.getValueAsDegrees());
									angleFound = true;
									return;
								}
							}
						}
						else {
							setScanAperture(new Angle(45/2, "Degrees"));
							setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/2, "Degrees"));
							lastScan = new Angle(lastScan.getValueAsDegrees() - 22.5/2, "Degrees");
							System.out.println("2"+ getLastScan().scanDirection.getValueAsDegrees());
							if(getLastScan().isTargetLocated()){
								setScanAperture(new Angle(45/4, "Degrees"));
								setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/4, "Degrees"));
								lastScan= new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
								System.out.println("3"+ getLastScan().scanDirection.getValueAsDegrees());
								if(getLastScan().isTargetLocated()){
									setScanAperture(new Angle(45/8, "Degrees"));
									setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
									lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/8, "Degrees");
									System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
									if(getLastScan().isTargetLocated()){
										angleFound = true;
										return;
									}
									else{
										setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
										lastScan= new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
										System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
										angleFound = true;
										return;
									}
								}
								else {
									setScanAperture(new Angle(45/8, "Degrees"));
									setScanDirection(new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees"));
									lastScan = new Angle(lastScan.getValueAsDegrees() + 22.5/8, "Degrees");
									System.out.println("4"+ getLastScan().scanDirection.getValueAsDegrees());
									if(getLastScan().isTargetLocated()){
										angleFound = true;
										return;
									}
									else{
										setScanDirection(new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees"));
										lastScan=new Angle(lastScan.getValueAsDegrees() - 22.5/4, "Degrees");
										System.out.println("5"+ getLastScan().scanDirection.getValueAsDegrees());
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
				a = new Angle(saveA.getValueAsDegrees() + 90, "Degrees");
				angleFound = false;
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
