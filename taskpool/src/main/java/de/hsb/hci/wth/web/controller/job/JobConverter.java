package de.hsb.hci.wth.web.controller.job;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.persistance.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("jobConverter")
public class JobConverter implements Converter {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return jobRepository.getAllJobs().stream()
                        .filter(job -> job.getId() == Integer.parseInt(value))
                        .findFirst().get();
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid job."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((Job) object).getId());
        } else {
            return null;
        }
    }
}
