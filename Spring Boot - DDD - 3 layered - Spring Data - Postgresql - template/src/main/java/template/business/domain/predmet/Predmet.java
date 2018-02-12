package template.business.domain.predmet;

/**
 * Created by Mate-1 on 5/19/2017.
 */
public class Predmet implements IPredmet {
    private int id;

    public Predmet(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //object mapping
    public Predmet() {
    }
}
