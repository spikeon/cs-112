
public abstract class AbstractCar {
	protected boolean on = false;
	protected int speed = 0;
	
	public abstract void toggleIgnition();
	public abstract int goFaster();
	
	public int getSpeed() {
		return speed;
	}

}
