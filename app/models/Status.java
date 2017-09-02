package models;

/* Created by Dmitry on 22.08.2017. */


import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Status extends Model {

    @OneToOne
    public User UserId;

    @OneToOne
    public Books BookId;

}
