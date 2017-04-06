package Policies;

import Main.MyFoodora;

public class TargetProfit_DeliveryCost implements ProfitPolicy {
	
	private MyFoodora system = MyFoodora.getInstance();
	private double markupPercentage;
	private double serviceFee;
	private double targetProfit;
	
	
	
	public TargetProfit_DeliveryCost(double markupPercentage, double serviceFee, double targetProfit) {
		super();
		this.markupPercentage = markupPercentage;
		this.serviceFee = serviceFee;
		this.targetProfit=targetProfit;
	}

	public double[] computeProfitFigures(){
		double[] incomeLastMonth = system.computeLastMonthIncomePerCustomerBis();
		double[] res = new double[3];
		res[0] = this.markupPercentage;
		res[1] = this.serviceFee;
		res[2] = Math.max(0,incomeLastMonth[0]*this.markupPercentage + this.serviceFee - this.targetProfit/incomeLastMonth[1]);
		return res;
	}
	
}