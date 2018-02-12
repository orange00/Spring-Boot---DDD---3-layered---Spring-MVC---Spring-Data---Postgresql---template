package template.interfacerDomainPersistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import template.business.domain.predmet.Predmet;
import template.persistence.dal.entities.PredmetDAL;

/**
 * Created by Mate-1 on 5/20/2017.
 */
@Component
public class DomainPersistenceMapper {
    private ModelMapper modelMapper;

    @Autowired
    public DomainPersistenceMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }

    //predmet
    public Predmet convertToDomain(PredmetDAL predmetDAL) {
        return modelMapper.map(predmetDAL, Predmet.class);
    }
    public PredmetDAL convertToDAL(Predmet predmet) {
        return modelMapper.map(predmet, PredmetDAL.class);
    }
}
