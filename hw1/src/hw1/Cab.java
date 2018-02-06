package hw1;
//Mason Walls
public class Cab 
{
	private double milesDriven;
	private double totalMiles;
	private double fare, rate,driveRate;
	private double money;
	private double meter;
	private boolean hasPassenger;
	public Cab(double a, double b)
	{
		fare = a;
		rate = 0;
		driveRate = b;
		money = 0;
		meter = 0;
		milesDriven = 0;
		totalMiles = 0;
	}
	public double getTotalMiles()
	{
		return totalMiles;
	}

	public double getMeter()
	{
		return meter;
	}
	public double getTotalCash()
	{
		return money;
	}
	public void pickUp()
	{
		meter=fare;
		rate = driveRate;
		hasPassenger = true;
	}
	public double getCurrentRate()
	{
		return rate;
	}
	public double getAverageIncomePerMile()
	{
		return money/totalMiles;
	}
	public void drive(double a)
	{
		totalMiles = totalMiles + a;
		milesDriven=a;
		meter = meter + milesDriven*rate;
	}
	public boolean hasPassenger()
	{
		return hasPassenger;
	}
	public void dropOff()
	{
		money+=meter;
		meter = 0;
		rate = 0;
		milesDriven=0;
		hasPassenger = false;
	}
}