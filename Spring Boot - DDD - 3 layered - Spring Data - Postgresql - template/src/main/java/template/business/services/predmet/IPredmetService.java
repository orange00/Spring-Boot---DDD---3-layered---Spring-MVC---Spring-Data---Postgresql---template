package template.business.services.predmet;

import template.business.domain.predmet.IPredmet;

/**
 * Created by Mate-1 on 5/19/2017.
 */
public interface IPredmetService {
    IPredmet findAll(int categoryId, int tagId, int page, int items, int filter);

    IPredmet find(int id);
}
