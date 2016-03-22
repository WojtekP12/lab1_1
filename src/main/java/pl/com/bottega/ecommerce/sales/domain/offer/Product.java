package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product 
{
	private String productId;
	private BigDecimal productPrice;
	private String productName;
	private Date productSnapshotDate;
	private String productType;
	private int quantity;
	private Money money;
	private boolean isAvailable;
	
	
	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType, int quantity, Money money, boolean isAvailable) 
	{
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.productSnapshotDate = productSnapshotDate;
		this.productType = productType;
		this.quantity = quantity;
		this.money = money;
		this.isAvailable = isAvailable;
	}
	
	public Product() {}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getProductSnapshotDate() {
		return productSnapshotDate;
	}

	public void setProductSnapshotDate(Date productSnapshotDate) {
		this.productSnapshotDate = productSnapshotDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}