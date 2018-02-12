package template.persistence.dal.entities.templateOnly;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mate-1 on 12/20/2016.
 */
public class Text implements IText {
    private boolean continues;
    private String text;
    private TextType type;

    public Text(String text, TextType type, boolean continues) {
        this.text = text;
        this.type = type;
        this.continues=continues;
    }

    /**
     * Only for Jackson.
     */
    public Text(){}

    public String getText() {
        return text;
    }

    public TextType getType() {
        return type;
    }

    public boolean isContinues() {
        return continues;
    }

    @Override
    public List<String> getLines() {
        BufferedReader bufReader = new BufferedReader(new StringReader(text));
        return bufReader.lines().collect(Collectors.toList());
    }

    @Override
    public boolean isUnorderedCollection() {
        return type.equals(TextType.Collection);
    }

    @Override
    public boolean isOrderedCollection() {
        return type.equals(TextType.NumberedCollection);
    }

    @Override
    public boolean isCollection() {
        return isOrderedCollection() || isUnorderedCollection();
    }

    @Override
    public boolean isTerminated() {
        List<String> lines=getLines();
        if(lines.size()<=1) {
            return false;
        }

        return lines.get(lines.size()-1).isEmpty();
    }

    @Override
    public String toString() {
        return text;
    }
}
