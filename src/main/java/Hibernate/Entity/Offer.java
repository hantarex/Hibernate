package Hibernate.Entity;

import javax.persistence.*;

/**
 * Created by Arnold on 09.04.2018.
 */
@Entity
@Table(name = "offer")
public class Offer {
    private Integer id;
    private String url;

    public Offer(){

    }

    public Offer(String url) {
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
