package template.persistence.dal.exampleCustomImplementation.unitingRepository;

import template.persistence.dal.exampleCustomImplementation.customImplementationPart.ICustomMolitvenikRepository;
import template.persistence.dal.exampleCustomImplementation.springImplementationPart.MolitvenikMongoRepository;

/**
 *  This is the full repository.
 *
 *  Spring will combine the auto implemented part and the custom implemented part and make this repository bean.
 *
 *  This repository should be injected (eg. autowired) in outside components.
 */
public interface IMolitvenikRepository extends MolitvenikMongoRepository, ICustomMolitvenikRepository {

}
