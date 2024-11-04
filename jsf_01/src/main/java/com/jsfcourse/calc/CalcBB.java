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
public class CalcBB{
	private Double amount;
	private Double length;
	private Double perc;
	private Double result;

	@Inject //DI - Dependencies Injection
	FacesContext ctx;
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getPerc() {
		return perc;
	}

	public void setPerc(Double perc) {
		this.perc = perc;
	}

	public Double getResult() {
		return result;
	}

	public String calc() {
		result = (amount + (amount * perc/100))/(length * 12);
			
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesieczna rata wynosi: " + result, null));
		
		return null;
	}

	public String info() {
		return "info";
	}

}
