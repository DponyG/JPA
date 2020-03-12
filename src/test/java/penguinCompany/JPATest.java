package penguinCompany;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.penguinCompany.entity.User;




@RunWith(Arquillian.class)
public class JPATest {
    
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    User user;
    
    
    @Deployment
    public static Archive<?> createDeploymentPackage() {
        return ShrinkWrap.create(WebArchive.class, "UserPersistenceTest.war")
                .addPackage(User.class.getPackage())
                .addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
}

    @Test
    public void test() {
        assertNotNull(em);
        assertNotNull(user);
    }

}
