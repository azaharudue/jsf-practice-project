/**
 *
 */
package com.jsftest.main.java.configs;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;

import com.jsftest.main.java.dao.GenericDao;
import com.jsftest.main.java.entities.AbstractEntity;

/**
 * @author Azahar Hossain
 * @param <T extends AbstractEntity>
 *
 */

public class GenericConverter<T extends AbstractEntity> implements Converter<T>
{
	private final GenericDao<T, Long> dao;
	EntityManager entityManager;

	public GenericConverter(final GenericDao<T, Long> dao)
	{

		this.dao = dao;

	}

	@Override
	public T getAsObject(final FacesContext facesContext, final UIComponent uiComponent, final String value)
	{
		T resultObject = null;

		if ((value != null) && !"".equals(value))
		{
			final Long id = new Long(value);
			resultObject = this.dao.findById(id);
		}

		return resultObject;

	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent uiComponent, final T o)
	{

		return (o == null) || (o.getId() == null) ? null : o.getId().toString();
	}
}
