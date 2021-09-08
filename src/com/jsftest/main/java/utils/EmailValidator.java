package com.jsftest.main.java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<Object>
{
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	private Matcher matcher;
	private final Pattern pattern;

	public EmailValidator()
	{
		this.pattern = Pattern.compile(EmailValidator.EMAIL_PATTERN);
	}

	@Override
	public void validate(final FacesContext context, final UIComponent uiComponent, final Object value) throws ValidatorException
	{
		this.matcher = this.pattern.matcher(value.toString());
		if (!this.matcher.matches())
		{
			final FacesMessage msg = new FacesMessage("E-mail validation failed.", "Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
