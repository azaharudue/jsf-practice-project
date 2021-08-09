package com.jsftest.main.java.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("sessionBean")
public class SessionBean implements Serializable
{

	/**
	 *
	 */
	private static final long serialVersionUID = -3729302704486017727L;

	public SessionBean()
	{

	}

	private Locale locale = Locale.GERMAN;

	@PostConstruct
	public void init()
	{
		// this.locale =
		// FacesContext.getCurrentInstance().getViewRoot().getLocale();
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
	}

	public Locale getLocale()
	{
		return this.locale;
	}

	public String getLanguage()
	{
		return this.locale.getLanguage();
	}

	public void setLanguage(final String language)
	{
		this.locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
	}
}
