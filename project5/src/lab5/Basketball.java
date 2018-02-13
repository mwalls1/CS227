package lab5;

public class Basketball {
	boolean isInflated = false;
	double diameter;

	public Basketball(double givenDiameter) {
		diameter = givenDiameter;
	}

	public boolean isDribbleable() {
		return isInflated;
	}

	public double getDiameter() {
		return diameter;
	}

	public double getCircumference() {
		return 0;
	}

	public void inflate() {
		isInflated=true;
	}
}
