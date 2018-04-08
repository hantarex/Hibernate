package Hibernate.Interfaces;

import Hibernate.Entity.Offer;

import java.sql.SQLException;

/**
 * Created by Arnold on 09.04.2018.
 */
public interface OfferInterface {
    public void addOffer(Offer offer) throws SQLException;
}
