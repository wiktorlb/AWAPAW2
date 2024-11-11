//package com.jsfcourse.calc;
//
//
//import jakarta.inject.Inject;
//import jakarta.inject.Named;
//
//import java.text.Normalizer.Form;
//import java.util.ResourceBundle;
//
//import org.apache.taglibs.standard.tag.common.xml.IfTag;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.enterprise.context.SessionScoped;
//import jakarta.faces.annotation.ManagedProperty;
//import jakarta.faces.application.FacesMessage;
//import jakarta.faces.context.FacesContext;
package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
//@RequestScoped
//@SessionScoped
@ViewScoped
public class CalcBB implements Serializable{
	private Double amount;
	private Double length;
	private Double perc;
	private Double result;

	// Resource injected
		@Inject
		@ManagedProperty("#{txtCalcErr}")
		private ResourceBundle txtCalcErr;

		// Resource injected
		@Inject
		@ManagedProperty("#{txtCalc}")
		private ResourceBundle txtCalc;
	
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
			
		ctx.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
		ctx.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("result") + ": " + result, null));
		
		return null;
	}

	public String info() {
		return "info";
	}

}
