package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money 
{
	private BigDecimal totalCost;
	private String currency;

	public Money(BigDecimal totalCost, String currency)
	{
		this.totalCost = totalCost;
		this.currency = currency;
	}
	
	public Money() {
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}