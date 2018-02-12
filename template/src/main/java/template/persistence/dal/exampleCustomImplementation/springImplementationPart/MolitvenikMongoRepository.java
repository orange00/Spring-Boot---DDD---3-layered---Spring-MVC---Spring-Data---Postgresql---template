package template.persistence.dal.exampleCustomImplementation.springImplementationPart;


import org.springframework.data.mongodb.repository.MongoRepository;
import template.persistence.dal.entities.templateOnly.IMolitvenik;

/**
 * This repository represents the list of methods that Spring will auto implement.
 *
 * Here we should write the method declarations which we want Spring to implement using naming
 * conventions.
 *
 * Here we have findByOrder method and methods from MongoRepository->PagingAndSortRepository->...
 */
public interface MolitvenikMongoRepository extends MongoRepository<IMolitvenik, String> {
    IMolitvenik findByOrder(int order);
}
