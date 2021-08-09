/**
 *
 */
package com.jsftest.main.java.entities;

import java.io.Serializable;

/**
 * @author Azahar Hossain
 *
 */
public abstract class AbstractEntity implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -3785367441047215509L;
	protected Long id;

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id)
	{
		this.id = id;
	}

}
