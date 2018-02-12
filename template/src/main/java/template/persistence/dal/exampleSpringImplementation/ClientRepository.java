package template.persistence.dal.exampleSpringImplementation;

import template.persistence.dal.entities.templateOnly.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @RepositoryRestResource tells Spring to make a Restful controller from this repo. The controller
 * URLs will match the methods in this repo.
 *
 * For example, the findByName method was exposed as a service. To access it simply use the URL http://localhost:8080/clients/search/findByName?name=John
 * To see all the available services you can access the URL http://localhost:8080/clients/search, which returns all available services

Read more: http://mrbool.com/rest-server-with-spring-data-spring-boot-and-postgresql/34023#ixzz4hXEFkg9x

 * Note: @Param is used only for the REST server created by @RepositoryRestResource
 * Note: It is not neccessary to put @Repository annotation. It is only neccessary to extend Spring Data
 * Repository class (super class of PagingAndSortingRepository)
 */
@RepositoryRestResource(collectionResourceRel = "client", path = "clients")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    /**
     * Method that returns a lista of clients doing a search by the passed name parameter.
     * * * @param name * @return list of clients
     */
    List<Client> findByName(@Param("name") String name);

    /**
     * Spring doesnt provide implementation for this method out of the box,
     * but uses the given query to implement the method.
     *
     * Method that returns a client with only its name doing a search by the passed id parameter.
     * * * @param id * @return client of the id passed as parameter.
     */
    @Query("SELECT c.name FROM Client c where c.id = :id")
    Client findNameById(@Param("id") Long id);

    /**
     * Method that returns a list of clients doing a search by the passed name parameter and sorting them by the name. * * @param name * @return list of clients
     */
    List<Client> findByNameOrderByName(@Param("name") String name);
}