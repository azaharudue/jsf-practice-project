/**
 *
 */
package com.jsftest.main.java.filters;

import java.io.Serializable;
import java.util.Set;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;

/**
 * @author Azahar Hossain
 *
 */

public class CompanyFilters extends CompanyDaoImpl implements Serializable
{
	private static final long serialVersionUID = 2898765607093856627L;

	public enum Group
	{
		NAME,
		LOCATION
	}

	private Set<Group> groups;

	/**
	 * @return the groups
	 */
	public Set<Group> getGroups()
	{
		return this.groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(final Set<Group> groups)
	{
		this.groups = groups;
	}

	public boolean isAnyFilter()
	{
		if (!this.groups.isEmpty() && (this.groups != null))
			return true;
		return false;
	}

}
