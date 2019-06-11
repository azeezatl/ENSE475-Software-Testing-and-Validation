package edu.ense475.FITCommission;

import fit.ColumnFixture;

public class CommissionTest extends ColumnFixture {
	public int locks;
	public int stocks;
	public int barrels;
	private final double lockPrice = 45.0;
	private final double stockPrice = 30.0;
	private final double barrelPrice = 25.0;
	
	public double testCalculateSales() {
		Commission commission = new Commission(lockPrice, stockPrice, barrelPrice);
		commission.processNewSale(locks, stocks, barrels);
		return commission.calculateSales();
	} 
	
	public double testCalculateCommission() {
		Commission commission = new Commission(lockPrice, stockPrice, barrelPrice);
		commission.processNewSale(locks, stocks, barrels);
		return commission.calculateCommission();
	}
}
