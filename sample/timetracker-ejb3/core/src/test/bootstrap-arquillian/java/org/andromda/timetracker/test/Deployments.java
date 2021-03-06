package org.andromda.timetracker.test;

import java.io.File;

import org.andromda.timetracker.action.Authenticator;
import org.andromda.timetracker.action.AuthenticatorAction;
import org.andromda.timetracker.action.LoginArquillianTest;
import org.andromda.timetracker.domain.UserDaoBase;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;

public class Deployments
{

    public static WebArchive appDeployment()
    {
        MavenResolverSystem resolver = Maven.resolver();

        // MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();
        File[] libs = resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.TEST, ScopeType.COMPILE, ScopeType.PROVIDED).resolve().withTransitivity().asFile();

        // File[] dependencyAndTransitives = resolver.resolve("org.jboss.seam:jboss-seam").withTransitivity().as(File.class);

        // File[] libs = Maven.resolver().loadPomFromFile("pom.xml").importCompileAndRuntimeDependencies()
        // resolve jboss-seam, because it is provided-scoped in the pom, but we need it bundled in the WAR
        // .resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile();

        return ShrinkWrap.create(WebArchive.class, "core.war").addClasses(LoginArquillianTest.class, Authenticator.class, AuthenticatorAction.class, UserDaoBase.class)
                .addPackages(true, "org.andromda.timetracker.action")
                .addPackages(true, "org.andromda.timetracker.domain")
                .addPackages(true, "org.andromda.timetracker")
                // Needed to run in managed / remote container
                .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml").addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(EmptyAsset.INSTANCE, "seam.properties")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml").addAsWebInfResource("WEB-INF/test-web.xml", "web.xml").addAsWebInfResource("WEB-INF/test-components.xml", "components.xml")
                .addAsWebInfResource("WEB-INF/jboss-deployment-structure.xml").addAsResource("META-INF/security.drl", "META-INF/security.drl").addAsResource("import.sql", "import.sql")
                .addAsResource("log4j.xml", "log4j.xml").addAsLibraries(libs)
        // resolve jboss-seam, because it is provided-scoped in the pom, but we need it bundled in the WAR
        // .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam:2.3.1.Final").withTransitivity().asFile())
        // libraries resolved using ShrinkWrap Resolver
        // .addAsLibraries(resolver.resolve("org.jboss.seam:jboss-seam").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("commons-collections:commons-collections").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.hibernate:hibernate-core").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.javassist:javassist").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.drools:drools-core").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.drools:drools-compiler").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.jbpm:jbpm-jpdl").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.jboss.el:jboss-el").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("javax.ejb:ejb-api").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("javax.el:el-api").withTransitivity().asFile())
        // .addAsLibraries(resolver.resolve("org.mvel:mvel2").withTransitivity().asFile())
        ;
        // .addAsLibraries(resolver.artifact("log4j:log4j").resolveAsFiles())
        // .addAsLibraries(libs);
        // .delete("/WEB-INF/web.xml")
        // web resources
        // .addAsWebResource("index.html")
        // .addAsWebResource("register.xhtml")
        // .addAsWebResource("registered.xhtml")
    }
}
