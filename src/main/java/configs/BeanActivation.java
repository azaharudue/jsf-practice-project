package main.java.configs;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;

@FacesConfig(
	// Activates CDI build-in beans
	version = FacesConfig.Version.JSF_2_3)
@ApplicationScoped
public class BeanActivation
{

}
