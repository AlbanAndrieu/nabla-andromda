package org.andromda.timetracker.action;

import java.util.Set;
import java.util.TreeSet;

import org.andromda.timetracker.test.Deployments;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AuthenticatorArquillianTest extends JUnitSeamTest // SeamOpenEjbTest
{

    private static final Logger LOGGER = Logger.getLogger(AuthenticatorArquillianTest.class);

    @Deployment(name = "AuthenticatorArquillianTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        return Deployments.appDeployment();
    }

    // Ignore Junit Test @Ignore("Pending improvment")
    @Test
    public void shouldAuthenticate() throws Exception
    {
        new ComponentTest()
        {
            @Override
            protected void testComponents() throws Exception
            {

                Identity.setSecurityEnabled(true);

                AuthenticatorArquillianTest.LOGGER.info("credentials : " + this.getValue("#{credentials}"));
                AuthenticatorArquillianTest.LOGGER.info("authenticator : " + this.getValue("#{authenticator}"));
                // given
                final Credentials cred = (Credentials) this.getValue("#{credentials}");
                final Authenticator auth = (Authenticator) this.getValue("#{authenticator}");

                // when
                cred.setUsername("admin");
                cred.setPassword("cooldude");

                AuthenticatorArquillianTest.LOGGER.info("credentials username : " + cred.getUsername());

                final boolean success1 = auth.authenticate();

                // then
                Assert.assertTrue(success1);

                final Set<String> roles = new TreeSet<String>();
                final boolean success2 = auth.authenticate("admin", "cooldude", roles);
                // then
                Assert.assertTrue(success2);

                for (final String role : roles)
                {
                    AuthenticatorArquillianTest.LOGGER.info("authenticator role : " + role);
                }
                Assert.assertEquals(roles.toString(), "[Administrator, StandardUser]");
                // AuthenticatorTest.logger.info("authenticator role hosRole : " + this.getValue("#{identity.checkRole(\"Administrator\")}"));

            }
        }.run();
    }

}
