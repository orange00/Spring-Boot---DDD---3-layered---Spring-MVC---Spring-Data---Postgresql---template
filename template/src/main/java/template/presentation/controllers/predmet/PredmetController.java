package template.presentation.controllers.predmet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.business.services.predmet.IPredmetService;
import template.interfacerPresentationDomain.PresentationDomainMapper;
import template.presentation.models.predmet.PredmetPL;

/**
 * A RESTFul controller for accessing predmet information.
 *
 * @RestController annotation on class level means that every method returns
 * an object, and not a view.
 *
 * @author Paul Chapman
 */
@RestController
public class PredmetController {
    private IPredmetService predmetService;
    private PresentationDomainMapper mapper;

    @Autowired
    public PredmetController(IPredmetService predmetService, PresentationDomainMapper mapper) {
        this.predmetService = predmetService;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/predmeti/{id}",produces = "application/json")
    public PredmetPL getContent(@PathVariable("id") int id) {
        //debug
        return mapper.convertToPL(predmetService.find(id));
    }
}
