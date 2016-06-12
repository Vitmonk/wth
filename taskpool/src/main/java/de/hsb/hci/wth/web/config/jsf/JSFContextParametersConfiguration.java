package de.hsb.hci.wth.web.config.jsf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class JSFContextParametersConfiguration implements ServletContextInitializer {

    private static final Log LOGGER = LogFactory.getLog(JSFContextParametersConfiguration.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("Initialising jsf dev parameters...");
        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString().toLowerCase());
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        servletContext.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString().toLowerCase());
        servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
        servletContext.setInitParameter("org.primefaces.extensions.DELIVER_UNCOMPRESSED_RESOURCES", Boolean.FALSE.toString().toLowerCase());

    }
}