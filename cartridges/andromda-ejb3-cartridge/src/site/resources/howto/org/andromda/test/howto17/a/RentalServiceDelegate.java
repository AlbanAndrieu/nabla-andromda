// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ServiceDelegate.vsl in andromda-ejb3-cartridge.
//
package org.andromda.howto2.rental;

import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import org.andromda.howto2.ServiceDelegateBase;
import org.andromda.howto2.ServiceLocator;

/**
 * Web service delegator for {@link org.andromda.howto2.rental.RentalServiceBean}.
 *
 * @see org.andromda.howto2.rental.RentalServiceBean
 */
public class RentalServiceDelegate
    extends ServiceDelegateBase
{
    /**
     * Default constructor
     */
    public RentalServiceDelegate()
    {
        super();
    }

    /**
     * Constructor setting the envirinment properties.
     *
     * @param properties
     */
    public RentalServiceDelegate(Properties properties)
    {
        super(properties);
    }

    /**
     * Gets an instance of {@link RentalServiceRemote}
     */
    private final RentalServiceRemote getRentalServiceRemote()
        throws NamingException
    {
        return ServiceLocator.getInstance().get_org_andromda_howto2_rental_RentalServiceBean_Remote(getProperties());
    }

    /**
     * @see org.andromda.howto2.rental.RentalServiceBean#getAllCars()
     *
     * Call the session bean operation using appropriate view type
     */
    public List getAllCars()
        throws RentalException
    {
        try
        {
            return getRentalServiceRemote().getAllCars();
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.howto2.rental.RentalService.getAllCars()' --> " + ex, ex);
        }
    }

    /**
     * @see org.andromda.howto2.rental.RentalServiceBean#getCustomersByName(String)
     *
     * Call the session bean operation using appropriate view type
     */
    public List getCustomersByName(String name)
        throws RentalException
    {
        try
        {
            return getRentalServiceRemote().getCustomersByName(name);
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.howto2.rental.RentalService.getCustomersByName(String name)' --> " + ex, ex);
        }
    }
}
