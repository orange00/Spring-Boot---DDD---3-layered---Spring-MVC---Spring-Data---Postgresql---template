package template.persistence.dal.entities.templateOnly;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mate-1 on 12/20/2016.
 */
public class Molitvenik implements IMolitvenik {
    //ne moze biti autowired, jer molitvenike kreira ko stigne
    //treba stavit da se prima preko konstruktora
    //pitanje je hoće li to radit kad se dohvati iz mongo baze,
    //kako to rijesit?? provjerit
//    @Autowired
//    private IVrsnaMolitvaRepository molitveRepository;

    private List<IVrsnaMolitva> molitve;

    @Id
    private String id;
    private int order;
    private String title;

    public Molitvenik(String title) {
        this.title=title;
        molitve=new ArrayList<>();
    }

    /**
     * Only for Jackson.
     */
    public Molitvenik() {
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void addMolitva(IVrsnaMolitva currentMolitva) {
        molitve.add(currentMolitva);
    }

    @Override
    public List<IVrsnaMolitva> getVrsneMolitve() {
        return molitve;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order=order;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
