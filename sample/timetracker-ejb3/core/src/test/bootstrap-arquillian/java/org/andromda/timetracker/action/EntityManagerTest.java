package org.andromda.timetracker.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;

import org.andromda.timetracker.domain.User;
import org.andromda.timetracker.test.Deployments;
import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.mock.JUnitSeamTest;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EntityManagerTest extends JUnitSeamTest
{
    private static final Logger LOGGER = Logger.getLogger(EntityManagerTest.class);

    @Deployment(name = "EntityManagerTest")
    @OverProtocol("Servlet 3.0")
    public static Archive<?> createTestArchive()
    {

        return Deployments.appDeployment();
    }

    // @Ignore("Pending improvment")
    @Test
    public void testEntityManager() throws Exception
    {
        // This is a transactionally aware EntityManager and must be accessed within a JTA transaction
        // Why aren't we using javax.persistence.Persistence? Well, our persistence.xml file uses
        // jta-datasource which means that it is created by the EJB container/embedded JBoss.
        // using javax.persistence.Persistence will just cause us an error
        final EntityManager em = (EntityManager) new InitialContext().lookup("java:/EntityManagerFactories/timetracker-ejb3");

        // final SeamManagedEntityManagerFactory bean = (SeamManagedEntityManagerFactory) Component.getInstance(SeamManagedEntityManagerFactoryBean.class, true);
        // final EntityManager em = bean.getEntityMangagerFactory().createEntityManager();

        // Obtain JBoss transaction
        final TransactionManager tm = (TransactionManager) new InitialContext().lookup("java:/TransactionManager");

        tm.begin();

        final Date date = (new SimpleDateFormat("yyyy-MM-dd hh:mm")).parse("2011-01-01 09:00");
        User user = new User("admin", "cooldude", "Alban", "Andrieu", "alban.andrieu@free.fr", true, date, "Alban Andrieu");
        em.persist(user);

        Assert.assertTrue(user.getId() > 0);

        final Long id = user.getId();

        System.out.println("created admin with id: " + id);

        tm.commit();

        tm.begin();
        user = em.find(User.class, id);
        Assert.assertNotNull(user);
        tm.commit();
    }

}
