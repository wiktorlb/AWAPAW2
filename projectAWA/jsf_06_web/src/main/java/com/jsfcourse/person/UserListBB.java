package com.jsfcourse.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ejb.EJB;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
import jakarta.servlet.http.HttpSession;

import com.jsf.dao.PersonDAO;
import com.jsf.dao.UserDAO;
import com.jsf.entities.Person;
import com.jsf.entities.User;

@Named
@RequestScoped
public class UserListBB {
	private static final String PAGE_PERSON_EDIT = "personEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String lastName;

	@Inject
	ExternalContext extcontext;

	@Inject
	Flash flash;

	@EJB
	UserDAO userDAO;

	/*
	 * public String getSurname() { return surname; }
	 */

	
	public String getLastName() { 
		return this.lastName; 
	}
	

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public List<User> getFullList() {
		return userDAO.getFullList();
	}

	public List<User> getList() {
		List<User> list = null;

		// 1. Prepare search params
		Map<String, Object> searchParams = new HashMap<String, Object>();

		if (lastName != null && lastName.length() > 0) {
			searchParams.put("lastName", lastName);
		}

		// 2. Get list
		list = userDAO.getList(searchParams);

		return list;
	}
	  public String newPerson(){ Person person = new Person();
	  
	  //1. Pass object through session //HttpSession session = (HttpSession)
	  extcontext.getSession(true); //session.setAttribute("person", person);
	  
	  //2. Pass object through flash flash.put("person", person);
	  
	  return PAGE_PERSON_EDIT; }
	  
	  public String editPerson(Person person){ //1. Pass object through session
	  //HttpSession session = (HttpSession) extcontext.getSession(true);
	  //session.setAttribute("person", person);
	  
	  //2. Pass object through flash flash.put("person", person);
	  
	  return PAGE_PERSON_EDIT; }
	  
	  public String deleteUser(User user){ userDAO.remove(user); return
	  PAGE_STAY_AT_THE_SAME; }
	 
}
