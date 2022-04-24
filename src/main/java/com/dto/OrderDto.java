package com.dto;

public class OrderDto {
	
	private String productName;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	
	public OrderDto() {
		super();
	}

	public OrderDto(String productName, String subtotal, String shipping, String tax, String total) {
		super();
		this.productName = productName;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSubtotal() {
		return String.format("%.2f", this.subtotal);
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public String getShipping() {
		return String.format("%.2f", this.shipping);
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public String getTax() {
		return String.format("%.2f", this.tax);
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getTotal() {
		return String.format("%.2f", this.total);
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderDetail [productName=" + productName + ", subtotal=" + subtotal + ", shipping=" + shipping
				+ ", tax=" + tax + ", total=" + total + "]";
	}

}
