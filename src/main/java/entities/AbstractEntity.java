/**
 *
 */
package main.java.entities;

/**
 * @author Azahar Hossain
 *
 */
public abstract class AbstractEntity
{
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
