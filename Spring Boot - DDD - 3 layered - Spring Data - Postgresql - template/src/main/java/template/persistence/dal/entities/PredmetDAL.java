package template.persistence.dal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mate-1 on 5/19/2017.
 */
@Entity
public class PredmetDAL {
    @GeneratedValue
    @Id
    public int id;


    //object mapping
    public PredmetDAL() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
