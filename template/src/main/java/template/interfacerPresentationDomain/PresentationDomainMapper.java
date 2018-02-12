package template.interfacerPresentationDomain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import template.business.domain.predmet.IPredmet;
import template.business.domain.predmet.Predmet;
import template.presentation.models.predmet.PredmetPL;

/**
 * Created by Mate-1 on 5/20/2017.
 */
@Component
public class PresentationDomainMapper {
    private ModelMapper modelMapper;

    @Autowired
    public PresentationDomainMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //predmet
    public PredmetPL convertToPL(IPredmet predmet) {
        return modelMapper.map(predmet, PredmetPL.class);
    }
    public Predmet convertToDomain(PredmetPL predmetPL) {
        return modelMapper.map(predmetPL, Predmet.class);
    }
}
