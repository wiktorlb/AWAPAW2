package com.jsfcourse.calc;


import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.text.Normalizer.Form;

import org.apache.taglibs.standard.tag.common.xml.IfTag;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String amount;
	private String length;
	private String perc;
	private Double result;

	@Inject //DI - Dependencies Injection
	FacesContext ctx;
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getPerc() {
		return perc;
	}

	public void setPerc(String perc) {
		this.perc = perc;
	}

	public Double getResult() {
		return result;
	}

	public boolean Math() {
		try {
			double amount = Double.parseDouble(this.amount);
			double length = Double.parseDouble(this.length);
			double perc = Double.parseDouble(this.perc);

			result = (amount + (amount * perc/100))/(length * 12);
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}
	public String calc() {
		if(Math()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesieczna rata wynosi: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}

}
