package template.persistence.dal.entities.templateOnly;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mate-1 on 12/20/2016.
 */
@Component
public class VrsnaMolitva implements IVrsnaMolitva {
    private IText title;

//    @Autowired
//    private ITextRepository textRepository;

    private List<IText> texts;

    public VrsnaMolitva(IText title) {
        this.title = title;
        texts=new ArrayList<>();
    }

    /**
     * Only for Jackson.
     */
    public VrsnaMolitva(){}

    @Override
    public void addText(IText textElement) {
        texts.add(textElement);
    }

    @Override
    public IText getTitle() {
        return title;
    }

    @Override
    public List<IText> getTexts() {
        return texts;
    }
}
