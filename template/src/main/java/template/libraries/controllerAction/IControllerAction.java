package template.libraries.controllerAction;

import org.springframework.beans.factory.annotation.Configurable;

import java.util.Optional;

/**
 * Created by Mate-1 on 12/3/2016.
 */
@Configurable
public interface IControllerAction<T> {
    Optional<T> execute();
}
