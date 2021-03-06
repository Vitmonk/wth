package de.hsb.hci.wth.web.model.persistance;

import java.util.List;

import de.hsb.hci.wth.web.model.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRepository {

    @Autowired
    private DemoDB demoDb;

    public List<Job> getAllJobs() {
        return demoDb.getJobs();
    }
}
