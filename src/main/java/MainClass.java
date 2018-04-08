import Hibernate.Controllers.OfferController;
import Hibernate.Entity.Contact;
import Hibernate.Entity.Offer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Arnold on 09.04.2018.
 */
public class MainClass {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return  sessionFactory;
    }

    public static void main(String[] args) throws SQLException {
        configureSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Offer offer = new Offer("test");

            session.save(offer);

            Contact contact = new Contact(5, "My Name", "my_email@email.com");
            session.save(contact);

            session.flush();
            transaction.commit();
        } catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
    }
}
