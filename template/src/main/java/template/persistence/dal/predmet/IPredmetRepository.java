package template.persistence.dal.predmet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import template.persistence.dal.entities.PredmetDAL;

import java.util.List;

/**
 */
public interface IPredmetRepository extends PagingAndSortingRepository<PredmetDAL, Integer> {

    PredmetDAL findById(int id);

    /**
     * Spring doesnt provide implementation for this method out of the box,
     * but uses the given query (JPQ - Java Persistence Query language) to implement the method.
     *
     * Method that returns a client with only its name doing a search by the passed id parameter.
     * * * @param id * @return client of the id passed as parameter.
     */
    @Query("SELECT p.id FROM PredmetDAL p where p.id = :id")
    /**
     * @Param tag is required for @Query processing, if the query
     * contains references by name(eg. :id) to method parameters.
     *
     * The most likely reason for this is the fact that the query processor does not neccesserily have
     * the names of the method parameters, only their values available.
     *
     * Another way to do this is to reference the method parameters in
     * query by order(replace :id with ?1) instead of by name. In that case @Param isn't needed.
     */
    int findIdById(@Param("id") int id);
}