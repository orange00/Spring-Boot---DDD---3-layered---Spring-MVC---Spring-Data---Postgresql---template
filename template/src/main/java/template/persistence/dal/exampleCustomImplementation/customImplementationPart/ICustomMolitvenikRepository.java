package template.persistence.dal.exampleCustomImplementation.customImplementationPart;

import template.persistence.dal.entities.templateOnly.IMolitvenik;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Here we should write the method declarations which we want to implement ourselves.
 */
@Repository
public interface ICustomMolitvenikRepository {
    void moveMolitvenikUp(String id);

    void moveMolitvenikDown(String id);

    Integer getOrder(String id);

    /**
     * Creates a new IMolitvenik with maximum ordering.
     * @param molitvenik
     * @return
     */
    IMolitvenik saveWithOrdering(IMolitvenik molitvenik);

    List<IMolitvenik> findAllSortByOrdering();

    void savePreserveOrdering(IMolitvenik molitvenik);

    void deleteResetOrderings(String id);
}
