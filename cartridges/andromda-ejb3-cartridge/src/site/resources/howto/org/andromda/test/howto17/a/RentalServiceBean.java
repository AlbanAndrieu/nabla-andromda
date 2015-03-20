// license-header java merge-point
//
// Generated by: SessionBeanImpl.vsl in andromda-ejb3-cartridge.
//
package org.andromda.howto2.rental;

import java.util.List;

/**
 * @see org.andromda.howto2.rental.RentalServiceBean
 */
/**
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, define the session bean in the ejb-jar.xml descriptor
 * @javax.ejb.Stateless
 */
/**
 * Uncomment to enable webservices for RentalServiceBean
 *@javax.jws.WebService(endpointInterface = "org.andromda.howto2.rental.RentalServiceWSInterface")
 */
public class RentalServiceBean
    extends RentalServiceBase
{
    // --------------- Constructors ---------------

    public RentalServiceBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see RentalServiceBase#getAllCars()
     */
    protected List handleGetAllCars()
        throws Exception
    {
        //TODO: put your implementation here.
        // Dummy return value, just that the file compiles
        return null;
    }

    /**
     * @see RentalServiceBase#getCustomersByName(String)
     */
    protected List handleGetCustomersByName(String name)
        throws Exception
    {
        //TODO: put your implementation here.
        // Dummy return value, just that the file compiles
        return null;
    }


    // -------- Lifecycle Callback Impl --------------
}
