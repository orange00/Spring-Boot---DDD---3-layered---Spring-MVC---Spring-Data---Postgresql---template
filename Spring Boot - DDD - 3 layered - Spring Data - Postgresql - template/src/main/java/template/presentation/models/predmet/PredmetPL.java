package template.presentation.models.predmet;

/**
 * Created by Mate-1 on 5/20/2017.
 */
public class PredmetPL {
    public int id;

    //debug
    public PredmetPL(int id) {
        this.id = id;
    }


    //object mapping
    public PredmetPL() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
