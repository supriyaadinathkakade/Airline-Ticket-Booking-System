package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class PaymentMode {
	@Enumerated(EnumType.STRING)
	@Column(name="payment_type",length = 20)
	private PaymentType paymentType;
	@Column(name="payment_amount")
	private double paymentAmount;
	@Column(name="payment_date")
	private LocalDate paymentDate;
	public PaymentMode() {
		// TODO Auto-generated constructor stub
	}
	public PaymentMode(PaymentType paymentType, double paymentAmount, LocalDate paymentDate) {
		super();
		this.paymentType = paymentType;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "PaymentMode [paymentType=" + paymentType + ", paymentAmount=" + paymentAmount + ", paymentDate="
				+ paymentDate + "]";
	}
	

}
