
package com.jsftest.main.java.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Azahar Hossain To manage sessions
 */
public class SessionUtils
{
	private static final SessionFactory sessionFactory;
	static
	{

		try
		{
			final Configuration config = new Configuration();
			sessionFactory = config.configure("com/jsftest/main/resources/hibernate.cfg.xml").buildSessionFactory();
		}
		catch (final Throwable e)
		{
			System.err.println("Error in creating SessionFactory object!" + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return SessionUtils.sessionFactory;
	}

}
