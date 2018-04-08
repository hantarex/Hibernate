package Hibernate.Controllers;

import Hibernate.Entity.Offer;
import Hibernate.Init;
import Hibernate.Interfaces.OfferInterface;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Arnold on 09.04.2018.
 */
public class OfferController implements OfferInterface{

    public void addOffer(Offer offer) throws SQLException {
        Session session = null;
        try{
            session = Init.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(offer);
            session.getTransaction().commit();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.OK_OPTION);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }
}
