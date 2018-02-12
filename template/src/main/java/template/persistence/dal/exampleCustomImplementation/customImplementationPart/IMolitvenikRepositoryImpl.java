package template.persistence.dal.exampleCustomImplementation.customImplementationPart;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import template.persistence.dal.entities.templateOnly.IMolitvenik;
import template.persistence.dal.exampleCustomImplementation.springImplementationPart.MolitvenikMongoRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Here we should write method implementations for the methods we want to implement outselves.
 *
 * IMPORTANT: This class must be named as named as <UnitingInterfaceName>Impl
 * by convention. Otherwise Spring wont be able to find it.
 */
public class IMolitvenikRepositoryImpl implements ICustomMolitvenikRepository {
    /**
     * This class can autowire and use the auto implemented (by Spring) part of our repository.
     */
    @Autowired
    private MolitvenikMongoRepository molitvenikMongoRepository;

    @Autowired
    private MongoOperations operations;

    /**
     * Ordering neće radit u kombinaciji sa brisanjem molitvenika.
     * Kad se izbriše neki molitvenik u sredini nastane rupa u orderingu.
     * Najjednostavnije(programerski) rješenje je resetiranje orderinga od početka do
     * kraja pri brisanju(ali je sporo, ali nema veze).
     * @param id
     */
    @Override
    public void moveMolitvenikUp(String id) {
        IMolitvenik molitvenik1=molitvenikMongoRepository.findOne(id);
        int order=molitvenik1.getOrder();
        if(order!=0) {
            molitvenik1.setOrder(order-1);

            IMolitvenik molitvenik2=molitvenikMongoRepository.findByOrder(order-1);
            molitvenik2.setOrder(order);

            molitvenikMongoRepository.save(molitvenik1);
            molitvenikMongoRepository.save(molitvenik2);
        }
    }


    @Override
    public void moveMolitvenikDown(String id) {
        IMolitvenik molitvenik1=molitvenikMongoRepository.findOne(id);
        int order=molitvenik1.getOrder();

        IMolitvenik molitvenik2=molitvenikMongoRepository.findByOrder(order+1);
        if(molitvenik2!=null) {
            molitvenik2.setOrder(order);
            molitvenik1.setOrder(order+1);

            molitvenikMongoRepository.save(molitvenik1);
            molitvenikMongoRepository.save(molitvenik2);
        }
    }

    @Override
    public Integer getOrder(String id) {
        return molitvenikMongoRepository.findOne(id).getOrder();
    }

    @Override
    public IMolitvenik saveWithOrdering(IMolitvenik molitvenik) {
        BasicQuery fetchMaxOrderedQuery=new BasicQuery("{}");
        fetchMaxOrderedQuery.setSortObject(new BasicDBObject("order",-1));
        fetchMaxOrderedQuery.limit(1);
        IMolitvenik maxOrdered=operations.findOne(fetchMaxOrderedQuery,IMolitvenik.class);
        int maxOrder=maxOrdered.getOrder();

        molitvenik.setOrder(maxOrder+1);

        return molitvenikMongoRepository.save(molitvenik);
    }

    @Override
    public List<IMolitvenik> findAllSortByOrdering() {
        List<IMolitvenik> all=molitvenikMongoRepository.findAll();
        Collections.sort(all, Comparator.comparingInt(m->m.getOrder()));

        return all;
    }

    @Override
    public void savePreserveOrdering(IMolitvenik molitvenik) {
        molitvenik.setOrder(molitvenikMongoRepository.findOne(molitvenik.getId()).getOrder());
        molitvenikMongoRepository.save(molitvenik);
    }

    @Override
    public void deleteResetOrderings(String id) {
        molitvenikMongoRepository.delete(id);

        List<IMolitvenik> all=findAllSortByOrdering();
        int order=0;
        for (IMolitvenik molitvenik :
                all) {
            molitvenik.setOrder(order);
            order++;
        }

        molitvenikMongoRepository.save(all);
    }
}
