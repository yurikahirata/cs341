package hirata;

import java.util.ArrayList;

public class LinearRegression {
	private ArrayList<Double> xData;
	private ArrayList<Double> yData;
	
	public LinearRegression(ArrayList<Double> xData, ArrayList<Double> yData) {
		this.xData = xData;
		this.yData = yData;
	}
	
	public int predictForValue (int predictForDependentVariable) {
		// Verify data sets are correct
		if (xData.size() != yData.size())
			throw new IllegalStateException("Data sets must be equal in size.");
		int nValues = xData.size();
		
		double sumXData = 0.0;
		double sumYData = 0.0;
		for (int i = 0; i< nValues; i++) {
			sumXData += xData.get(i);
			sumYData += yData.get(i);
		}
		
		// Compute mean
		double xDataBar = sumXData / nValues;
		double yDataBar = sumYData / nValues;
		
		// Compute least squares regression line
		// Subtract the hour mean value from the hour data values and square it
		double xxbar = 0.0;
		double xybar = 0.0;
		for (int i = 0; i< nValues; i++) {
			xxbar += (xData.get(i) - xDataBar) * (xData.get(i) - xDataBar);
			xybar += (yData.get(i) - yDataBar) * (yData.get(i) - yDataBar);
		}
		
		// Compute slope and intercept
		double slope = xybar / xxbar;
		double intercept = yDataBar - slope * xDataBar;
		
		// Compute prediction
		return (int) (intercept + slope * predictForDependentVariable);
	}

}
