package org.andromda.timetracker.action;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.test.Deployments;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Lifecycle;
import org.jboss.seam.core.Manager;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LoginArquillianTest extends JUnitSeamTest
{
    @Deployment(name = "LoginArquillianTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createDeployment()
    {

        return Deployments.appDeployment();
    }

    // @Before
    public void before()
    {
        Lifecycle.beginCall();
    }

    // @After
    public void after()
    {
        Lifecycle.endCall();
    }

    @Test
    public void testLoginComponent() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {
                Identity identity = Identity.instance();

                Assert.assertFalse(identity.isLoggedIn());
                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                User user = (User) Component.getInstance("user");
                Assert.assertEquals("admin", user.getUsername());
                Assert.assertEquals("cooldude", user.getPassword());
                Assert.assertEquals("Alban", user.getFirstName());
                Assert.assertEquals("Andrieu", user.getLastName());

                Assert.assertTrue(identity.isLoggedIn());
                identity.logout();
                Assert.assertFalse(identity.isLoggedIn());
                identity.setUsername("gavin");
                identity.setPassword("tiger");
                identity.login();
                Assert.assertFalse(identity.isLoggedIn());
            }
        }.run();
    }

    @Test
    public void testLogin() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {
                Identity identity = Identity.instance();

                Assert.assertFalse(identity.isLoggedIn());

                identity.setUsername("admin");
                identity.setPassword("cooldude");
                identity.login();

                User user = (User) Component.getInstance("user");
                Assert.assertEquals("admin", user.getUsername());
                Assert.assertEquals("cooldude", user.getPassword());
                Assert.assertEquals("Alban", user.getFirstName());
                Assert.assertEquals("Andrieu", user.getLastName());
                Assert.assertFalse(Manager.instance().isLongRunningConversation());
                Assert.assertTrue(identity.isLoggedIn());

                identity.logout();
                Assert.assertTrue(Session.instance().isInvalid());

                Assert.assertFalse(identity.isLoggedIn());
            }
        }.run();
    }

}
