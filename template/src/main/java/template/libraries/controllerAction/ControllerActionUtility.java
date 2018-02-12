package template.libraries.controllerAction;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Mate-1 on 12/5/2016.
 */
public class ControllerActionUtility {
    public static  <T> Optional<T> performControllerAction(IControllerAction<T> action, String errorMessage, HttpServletResponse response) throws IOException {
        try {
            return action.execute();
        } catch (IllegalArgumentException | NullPointerException ex) {
            response.sendError(400, errorMessage);
        }

        return Optional.empty();
    }
}
