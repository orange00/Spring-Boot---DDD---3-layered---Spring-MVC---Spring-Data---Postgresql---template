package template.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import template.libraries.controllerAction.ControllerActionUtility;
import template.libraries.utils.HTTPUtils;

/**
 * Created by Mate-1 on 12/27/2016.
 */
@Configuration
public class GeneralConfigSomeApps {
    @Bean
    public HTTPUtils httpUtility() {
        return new HTTPUtils();
    }

    @Bean
    public ControllerActionUtility controllerActionUtility() {
        return new ControllerActionUtility();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
