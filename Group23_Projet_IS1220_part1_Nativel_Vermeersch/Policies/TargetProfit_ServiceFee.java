package Policies;

import Main.MyFoodora;

public class TargetProfit_ServiceFee implements ProfitPolicy {
	
	private MyFoodora system = MyFoodora.getInstance();
	
	private double markupPercentage;
	private double deliveryCost;
	private double targetProfit;

	public TargetProfit_ServiceFee(double markupPercentage, double deliveryCost, double targetProfit) {
		super();
		this.markupPercentage = markupPercentage;
		this.deliveryCost = deliveryCost;
		this.targetProfit = targetProfit;
	}

	public double[] computeProfitFigures(){
		double[] incomeLastMonth = system.computeLastMonthIncomePerCustomerBis();
		double[] res = new double[3];
		res[1] = Math.max(0,(this.deliveryCost - this.markupPercentage*incomeLastMonth[0] + this.targetProfit/incomeLastMonth[1]));
		res[0] = this.markupPercentage;
		res[2] = this.deliveryCost;
		return res;
	}
}