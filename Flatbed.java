package Car;

public class Flatbed implements IFlatbedAngle {

	private double angle;

	public Flatbed() {
		angle = 0;
	}

	public void increaseAngle(double amount) {
		if (angle + amount <= 70 && amount > 0) {
			angle += amount;
		}
	}

	public void decreaseAngle(double amount) {
		if (angle - amount >= 0 && amount > 0) {
			angle -= amount;
		}
	}

	@Override
	public double getAngleFlatbed() {
		return angle;
	}

}
