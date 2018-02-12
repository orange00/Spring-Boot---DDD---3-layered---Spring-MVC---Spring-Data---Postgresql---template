package template.persistence.dal.entities.templateOnly;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Created by Mate-1 on 12/20/2016.
 */
@JsonDeserialize(as = VrsnaMolitva.class)
public interface IVrsnaMolitva {
    /**
     * @param textElement
     * @return
     */
    void addText(IText textElement);

    IText getTitle();

    List<IText> getTexts();
}
