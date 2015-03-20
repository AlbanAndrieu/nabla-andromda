// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!!
// Generated by crud/ManageableServiceUpdateException.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain.crud;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * TODO: Model Documentation for org.andromda.timetracker.domain.Movie
 */
public class MovieUpdateManageableException
    extends Exception
{
    /**
     * The default constructor.
     */
    public MovieUpdateManageableException()
    {}

    /**
     * Constructs a new instance of MovieUpdateManageableException
     *
     * @param throwable the parent Throwable
     */
    public MovieUpdateManageableException(Throwable throwable)
    {
        super(findRootCause(throwable));
    }

    /**
     * Constructs a new instance of MovieUpdateManageableException
     *
     * @param message the throwable message.
     */
    public MovieUpdateManageableException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new instance of MovieUpdateManageableException
     *
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public MovieUpdateManageableException(String message, Throwable throwable)
    {
        super(message, findRootCause(throwable));
    }

    /**
     * Finds the root cause of the parent exception
     * by traveling up the exception tree
     */
    private static Throwable findRootCause(Throwable th)
    {
        if (th != null)
        {
            // Lets reflectively get any JMX or EJB exception causes.
            try
            {
                Throwable targetException = null;
                // java.lang.reflect.InvocationTargetException
                // or javax.management.ReflectionException
                String exceptionProperty = "targetException";
                if (PropertyUtils.isReadable(th, exceptionProperty))
                {
                    targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                }
                else
                {
                    exceptionProperty = "causedByException";
                    //javax.ejb.EJBException
                    if (PropertyUtils.isReadable(th, exceptionProperty))
                    {
                        targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                    }
                }
                if (targetException != null)
                {
                    th = targetException;
                }
            }
            catch (Exception ex)
            {
                // just print the exception and continue
                ex.printStackTrace();
            }

            if (th.getCause() != null)
            {
                th = th.getCause();
                th = findRootCause(th);
            }
        }
        return th;
    }
}