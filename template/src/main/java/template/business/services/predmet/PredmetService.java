package template.business.services.predmet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.business.domain.predmet.IPredmet;
import template.business.domain.predmet.Predmet;
import template.interfacerDomainPersistence.DomainPersistenceMapper;
import template.persistence.dal.predmet.IPredmetRepository;

/**
 * @Transactional at class level: all public methods are @Transactional
 *
 * @Transactional annotation should be at the business service level. Either on the
 * business service class (eg., PredmetService) or on the business service class method (eg. PredmetService#find(id))
 *
 * @Transactional annotation works out of the box with Spring boot.
 * No additional dependencies are required.
 *
 * All you have to do is have a data source configured (eg. postgresql) and
 * have a jdbc-starter or jpa-starter dependency included.
 *
 * How it works:
 * Spring boot will detect the database driver and will create a DataSource.
 * Spring boot will detect the jdbc-starter and will create a JdbcTemplate bean for database access.
 * Spring boot will detect the jpa-starter and will create an EntityManager bean for database access.
 * After that, since you have the proper infrastructure(DataSource + JdbcTemplate or EntiyManager) configured (with NO custom configuration),
 * Spring boot will create a DataSourceTransactionManager bean.
 * DataSourceTransactionManager bean is used for all transaction management.
 */
@Transactional
@Service
public class PredmetService implements IPredmetService{
    private IPredmetRepository predmetRepository;
    private DomainPersistenceMapper mapper;

    @Autowired
    public PredmetService(IPredmetRepository predmetRepository, DomainPersistenceMapper mapper) {
        this.predmetRepository = predmetRepository;
        this.mapper = mapper;
    }

    @Override
    public IPredmet findAll(int categoryId, int tagId, int page, int items, int filter) {
        //debug
        return new Predmet(5);
    }

    @Override
    public IPredmet find(int id) {
        //debug
        System.out.println(predmetRepository.findIdById(1));
        return mapper.convertToDomain(predmetRepository.findById(id));
    }
}
