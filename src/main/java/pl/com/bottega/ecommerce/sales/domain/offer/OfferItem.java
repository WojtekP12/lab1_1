/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import pl.com.bottega.ecommerce.sales.domain.offer.Product;
import pl.com.bottega.ecommerce.sales.domain.offer.Money;
import pl.com.bottega.ecommerce.sales.domain.offer.Discount;

public class OfferItem 
{

	private Product product = new Product();

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	private Money money = new Money();

	private Discount discount = new Discount();


	public OfferItem(Product product, Money money, Discount discout) 
	{
		this.product = product;
		this.money = money;
		this.discount = discount;
		
		BigDecimal discountValue = new BigDecimal(0);
		if (discount.getDiscount() != null)
		{
			discountValue = discountValue.subtract(discount.getDiscount());
		}
		
		money.setTotalCost(product.getProductPrice().multiply(new BigDecimal(product.getQuantity())).subtract(discountValue));
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product.getProductName() == null) ? 0 : product.getProductName().hashCode());
		result = prime * result + ((product.getProductPrice() == null) ? 0 : product.getProductPrice().hashCode());
		result = prime * result + ((product.getProductId() == null) ? 0 : product.getProductId().hashCode());
		result = prime * result + ((product.getProductType() == null) ? 0 : product.getProductType().hashCode());
		result = prime * result + product.getQuantity();
		result = prime * result + ((money.getTotalCost() == null) ? 0 : money.getTotalCost().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) { return true; }
			
		if (obj == null) { return false; }
			
		if (getClass() != obj.getClass()) { return false; }
			
		OfferItem other = (OfferItem) obj;
		
		if (discount == null && other.discount != null) 
		{
			return false;
		} 
		else if (!discount.equals(other.discount))
		{
			return false;
		}
			
		if (product.getProductName() == null && other.product.getProductName() != null) 
		{
			return false;		
		} 
		else if (!product.getProductName().equals(other.product.getProductName()))
		{
			return false;
		}
			
		
		if (product.getProductPrice() == null && other.product.getProductPrice() != null) 
		{
			return false;
		} 
		else if (!product.getProductPrice().equals(other.product.getProductPrice()))
		{
			return false;
		}
			
		
		if (product.getProductId() == null && other.product.getProductId() != null) 
		{
			return false;		
		} 
		else if (!product.getProductId().equals(other.product.getProductId())) 
		{ 
			return false; 
		}
		
		if (product.getProductType() != other.product.getProductType() || product.getQuantity() != other.product.getQuantity()) 
		{ 
			return false;
		}
		
		if (money.getTotalCost() == null && other.money.getTotalCost() != null) 
		{
			return false;
		} 
		else if (!money.getTotalCost().equals(other.money.getTotalCost()))
		{ 
			return false; 
		}
		
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) 
	{
		if (product.getProductName() == null && other.product.getProductName() != null) 
		{
				return false;
		} 
		else if (!product.getProductName().equals(other.product.getProductName()))
		{
			return false;
		}
			
		if (product.getProductPrice() == null && other.product.getProductPrice() != null) 
		{
				return false;
		} 
		else if (!product.getProductPrice().equals(other.product.getProductPrice()))
		{
			return false;
		}
			
		if (product.getProductId() == null && other.product.getProductId() != null) 
		{
				return false;
		} 
		else if (!product.getProductId().equals(other.product.getProductId()))
		{
			return false;
		}
			
		if (product.getProductType() != other.product.getProductType() || product.getQuantity() != other.product.getQuantity())
		{
			return false;
		}

		BigDecimal max, min;
		
		if (money.getTotalCost().compareTo(other.money.getTotalCost()) > 0) 
		{
			max = money.getTotalCost();
			min = other.money.getTotalCost();
		} 
		else 
		{
			max = other.money.getTotalCost();
			min = money.getTotalCost();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
