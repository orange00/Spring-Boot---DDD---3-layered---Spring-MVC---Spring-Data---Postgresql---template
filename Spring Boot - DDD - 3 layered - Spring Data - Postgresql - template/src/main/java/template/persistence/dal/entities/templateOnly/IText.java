package template.persistence.dal.entities.templateOnly;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Created by Mate-1 on 12/20/2016.
 */
@JsonDeserialize(as = Text.class)
public interface IText{
    String getText();
    TextType getType();
    List<String> getLines();
    boolean isUnorderedCollection();
    boolean isOrderedCollection();
    boolean isCollection();

    /**
     * Returns whether this text is terminated
     * by an empty line(newline) at the end.
     * @return
     */
    boolean isTerminated();

    public boolean isContinues();
}
