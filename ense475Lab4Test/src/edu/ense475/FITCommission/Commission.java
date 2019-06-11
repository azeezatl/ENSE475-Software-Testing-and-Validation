package edu.ense475.FITCommission;

/**
 * Calculates sales and commission
 * @author azeezatlawal  
 */
 
public class Commission extends java.lang.Object{
	private static double Low_Sale = 1000.0;
	private static double High_Sale = 1800.0;
	private static double Commission_Ten = 0.1;
	private static double Commission_Fifteen = 0.15;
	private static double Commission_Twenty = 0.2;

	private int locks;
	private int stocks;
	private int barrels;
	
	private double lockPrice;
	private double stockPrice;
	private double barrelPrice;
	
	private double sales;
	private double commission;
	
	/**
	 * This sets the locks, stocks, barrels of the commission to process for sale.
	 * @param locks - locks that have been sold
	 * @param stocks - stocks that have been sold
	 * @param barrels - barrels that have been sold
	 */
	public void processNewSale(int locks, int stocks, int barrels) {
		if(locks < 1)
			this.locks = 1;
		else if(locks > 70)
			this.locks = 70;
		else
			this.locks = locks;
		
		if(stocks < 1)
			this.stocks = 1;
		else if(stocks > 80)
			this.stocks = 80;
		else
			this.stocks = stocks;
		
		if(barrels < 1)
			this.barrels = 1;
		else if(barrels > 90)
			this.barrels = 90;
		else
			this.barrels = barrels;
	}

	/**
	 * Initializes the prices for the lock, stock, and barrel
	 * @param lockPrice - price of the lock
	 * @param stockPrice - price of the stock
	 * @param barrelPrice - price of the barrel
	 */
	Commission(double lockPrice, double stockPrice, double barrelPrice){
		this.lockPrice = lockPrice;
		this.stockPrice = stockPrice;
		this.barrelPrice = barrelPrice;
	}
	
	/**
	 * Calculates sales
	 *  @return sales
	 */
	public double calculateSales() {
		this.sales = ((locks * lockPrice) + (stocks * stockPrice) + (barrels * barrelPrice));
		return this.sales;
	}
	
	/**
	 * Calculates commission
	 *  @return commission
	 */
	public double calculateCommission() {
		this.sales = this.calculateSales();
		
		if(this.sales <= Low_Sale)
			this.commission = Commission_Ten * this.sales;
		
		else if((this.sales > Low_Sale) && (this.sales <= High_Sale))
			this.commission = (Commission_Ten * 1000) + (Commission_Fifteen  * (this.sales-1000));
		
		else if(this.sales > High_Sale)
			this.commission = (Commission_Ten * 1000) + (Commission_Fifteen * 800) + (Commission_Twenty * (this.sales-1800));
		
		return this.commission;
	}

}
