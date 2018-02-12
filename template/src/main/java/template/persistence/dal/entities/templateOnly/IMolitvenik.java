package template.persistence.dal.entities.templateOnly;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

/**
 * Created by Mate-1 on 12/20/2016.
 */
@JsonDeserialize(as = Molitvenik.class)
public interface IMolitvenik {
    String getTitle();

    void addMolitva(IVrsnaMolitva currentMolitva);

    List<IVrsnaMolitva> getVrsneMolitve();

    int getOrder();
    void setOrder(int order);

    String getId();

    void setId(String id);
}
