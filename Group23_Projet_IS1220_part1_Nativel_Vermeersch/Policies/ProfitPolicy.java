package Policies;

import java.util.ArrayList;

public interface ProfitPolicy {
	
	/**
	 * 
	 * @return a 3-sized array with markup - service fee - delivery cost
	 */
	public double[] computeProfitFigures();
	
}