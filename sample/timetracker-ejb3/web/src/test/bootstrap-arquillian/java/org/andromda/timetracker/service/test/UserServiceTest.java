// license-header java merge-point
//
// Generated by test/SessionTest.vsl in andromda-ejb3-cartridge on 03/29/2012 12:08:36.
//
package org.andromda.timetracker.service.test;

import java.io.File;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.andromda.timetracker.ServiceLocator;
import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.domain.Role;
import org.andromda.timetracker.domain.UserDaoBase;
import org.andromda.timetracker.security.PasswordEncoder;
import org.andromda.timetracker.service.UserDoesNotExistException;
import org.andromda.timetracker.service.UserServiceBean;
import org.andromda.timetracker.service.UserServiceLocal;
import org.andromda.timetracker.service.UserServiceRemote;
import org.andromda.timetracker.vo.UserDetailsVO;
import org.andromda.timetracker.vo.UserRoleVO;
import org.andromda.timetracker.vo.UserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Service test class UserServiceTest for testing with TestNG
 * Check the testng.xml for initialization of the EJB3Container before running any tests.
 */
@RunWith(Arquillian.class)
public class UserServiceTest extends JUnitSeamTest
{
    private static final Log logger = LogFactory.getLog(UserServiceTest.class);

    @Deployment(name = "AuthenticatorArquillianTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        MavenResolverSystem resolver = Maven.resolver();

        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        return ShrinkWrap
                .create(WebArchive.class, "core.war")
                .addClasses(UserServiceTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class)
                .addPackages(true, "org.andromda.timetracker.action")
                .addPackages(true, "org.andromda.timetracker.domain")
                .addPackages(true, "org.andromda.timetracker.service")
                .addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml").addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                // .addAsWebInfResource("test-ds.xml", "test-ds.xml")
                .addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml").addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml")
                .addAsResource("META-INF/security.drl", "META-INF/security.drl").addAsResource("import.sql", "import.sql").addAsResource("log4j.xml", "log4j.xml")
                // libraries resolved using ShrinkWrap Resolver
                .addAsLibraries(libs)
        // other libraries resolved using ShrinkWrap Resolver
        // needed for FacesMessages
        // .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam:2.3.1.Final").withTransitivity().asFile())
        ;
    }

    @Test
    public void testSimpleComponentService() throws Exception
    {
        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                try
                {
                    final UserServiceLocal userService = (UserServiceLocal) Component.getInstance(UserServiceBean.class, true);
                    Assert.assertNotNull(userService);
                    UserServiceTest.logger.debug("Service : " + userService.toString());

                } catch (Exception e)
                {
                    UserServiceTest.logger.warn("Failed test SecurityServiceBean", e);
                    Assert.fail();
                }
            }
        }.run();
    }

    @Test
    public void testSimpleLookupService()
    {

        try
        {
            final InitialContext initialContext = this.getInitialContext();
            final UserServiceLocal userService = (UserServiceLocal) initialContext.lookup("java:app/core/UserServiceBean/local");
            Assert.assertNotNull(userService);
            UserServiceTest.logger.debug("Service : " + userService.toString());
        }
        catch (final Exception e)
        {
            UserServiceTest.logger.warn("Failed test UserServiceBean", e);
            Assert.fail();
        }

    }

    @Test
    public void testLookupPathLocalService()
    {
        UserServiceLocal userService;
        try
        {
            final InitialContext initialContext = this.getInitialContext();
            userService = (UserServiceLocal) initialContext.lookup(/* JNDI_PREFIX_NAME + */"UserServiceBean/Local");
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        } catch (final Exception e)
        {
            UserServiceTest.logger.warn("Failed test UserServiceBean", e);
            Assert.fail();
        }

    }

    // @Test
    public void testLookupPathRemoteService()
    {
        UserServiceRemote userService;
        try
        {
            final InitialContext initialContext = this.getInitialContext();
            userService = (UserServiceRemote) initialContext.lookup(/* JNDI_PREFIX_NAME + */"UserServiceBean/Remote");
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        } catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            Assert.fail();
        } catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    // @Test
    // public void testOtherLookupPathRemoteService()
    // {
    // UserServiceRemote userService;
    // try
    // {
    // userService = ServiceLocator.getInstance().getUserService();
    // UserServiceTest.logger.debug("Service : " + userService.toString());
    // Assert.assertNotNull(userService);
    // }
    // catch (final NamingException e)
    // {
    // UserServiceTest.logger.debug("NamingException : " + e);
    // Assert.fail();
    // }
    // catch (final Exception e)
    // {
    // UserServiceTest.logger.debug("Exception : " + e);
    // Assert.fail();
    // }
    //
    // }

    // @Test
    @Ignore("Pending improvment")
    public void testServiceLocatorLookupPathRemoteService()
    {
        UserServiceRemote userService;
        try
        {
            // final Properties prop = new Properties();
            // prop.putAll(EJB3Container.getInitialContextProperties());
            userService = ServiceLocator.getInstance().get_org_andromda_timetracker_service_UserServiceBean_Remote(null/* prop */);
            UserServiceTest.logger.debug("Service : " + userService.toString());
            Assert.assertNotNull(userService);
        } catch (final NamingException e)
        {
            UserServiceTest.logger.debug("NamingException : " + e);
            Assert.fail();
        } catch (final Exception e)
        {
            UserServiceTest.logger.debug("Exception : " + e);
            Assert.fail();
        }

    }

    // @Test
    @Ignore("Pending improvment")
    public void testGetUser()
    {
        // try
        // {
        // org.andromda.timetracker.service.UserServiceRemote userService = (org.andromda.timetracker.service.UserServiceRemote)EJB3Container.getInitialContext().lookup("UserServiceBean/remote");
        // test implementation
        // }
        // catch (Exception ex)
        // {
        // logger.warn("Failed test testGetUser()", ex);
        // }
    }

    /**
     * See Junit test EmbeddedEjb3TestCase.
     */
    @Test
    public void testRegisterUser() throws Exception
    {

        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {

                try
                {

                    // final UserServiceRemote userService = (UserServiceRemote) EJB3Container.getInitialContext("user", "password").lookup("UserServiceBean/remote");
                    // final UserServiceLocal userService = (UserServiceLocal) EJB3Container.getInitialContext().lookup("UserServiceBean/local");
                    // final UserServiceLocal userService = this.doJndiLookup("UserServiceBean");
                    final UserServiceLocal userService = (UserServiceLocal) Component.getInstance(UserServiceBean.class, true);

                    // Remote testuser if it already exists
                    UserVO userVO = null;
                    try
                    {
                        userVO = userService.getUser("testusertmp");
                        if ((userVO != null) && (userVO.getId().longValue() > 0))
                        {
                            userService.removeUser(userVO);
                        }
                    } catch (final UserDoesNotExistException e)
                    {
                        UserServiceTest.logger.debug("UserDoesNotExistException : " + e);
                    } catch (final Exception e)
                    {
                        UserServiceTest.logger.debug("Exception : " + e);
                        Assert.fail();
                    }

                    // Add testuser
                    UserDetailsVO udVO = new UserDetailsVO();
                    udVO.setFirstName("testusertmp");
                    udVO.setLastName("testusertmp");
                    udVO.setEmail("testtmp@test.com");
                    udVO.setIsActive(false);
                    udVO.setUsername("testusertmp");
                    udVO.setPassword(PasswordEncoder.getMD5Base64EncodedPassword("cooldude"));
                    udVO.setCreationDate(new Date());

                    final UserRoleVO urVO = new UserRoleVO();
                    urVO.setRole(Role.STANDARD_USER);

                    udVO.setRoles(new UserRoleVO[]
                    { urVO });

                    udVO = userService.registerUser(udVO);

                    Assert.assertNotNull(udVO);
                    Assert.assertTrue(udVO.getId().longValue() > 0);

                    UserServiceTest.logger.info("Registered new user: " + udVO.getFirstName() + ", " + udVO.getId());
                    try
                    {
                        // Remove testuser if it already exists

                        userVO = userService.getUser("testusertmp");
                        if ((userVO != null) && (userVO.getId().longValue() > 0))
                        {
                            userService.removeUser(userVO);
                        }
                    } catch (final UserDoesNotExistException e)
                    {
                        UserServiceTest.logger.debug("UserDoesNotExistException : " + e);
                        Assert.fail();
                    }
                } catch (final Exception ex)
                {
                    UserServiceTest.logger.warn("Failed test testRegisterUser()", ex);
                    Assert.fail();
                }
            }

        }.run();

    }

    @Test
    public void testGetAllUsers() throws Exception
    {

        new ComponentTest()
        {

            @Override
            protected void testComponents() throws Exception
            {
                // final UserServiceRemote userService = (UserServiceRemote) EJB3Container.getInitialContext("user", "password").lookup("UserServiceBean/remote");
                final UserServiceLocal userService = (UserServiceLocal) Component.getInstance(UserServiceBean.class, true);

                try
                {
                    final UserVO[] users = userService.getAllUsers();
                    Assert.assertTrue(users.length > 0);

                    for (final UserVO userVO : users)
                    {
                        UserServiceTest.logger.info("user : " + userVO.getFirstName());
                    }
                } catch (final Exception ex)
                {
                    UserServiceTest.logger.warn("Failed test testGetAllUsers()", ex);
                    // if reached that means that database is empty and default values have not been inserted
                    Assert.fail();
                }
            }

        }.run();

    }

}
