package Policies;

import Main.MyFoodora;

public class TargetProfit_Markup implements ProfitPolicy {
	
	private MyFoodora system = MyFoodora.getInstance();
	
	private double serviceFee;
	private double deliveryCost;
	private double targetProfit;

	public TargetProfit_Markup(double serviceFee, double deliveryCost, double targetProfit) {
		super();
		this.serviceFee = serviceFee;
		this.deliveryCost = deliveryCost;
		this.targetProfit = targetProfit;
	}

	public double[] computeProfitFigures(){
		double[] incomeLastMonth = system.computeLastMonthIncomePerCustomerBis();
		double[] res = new double[3];
		res[0] = Math.max(0,(this.deliveryCost - this.serviceFee + this.targetProfit/incomeLastMonth[1])/incomeLastMonth[0]);
		res[1] = this.serviceFee;
		res[2] = this.deliveryCost;
		return res;
	}
}