package de.hsb.hci.wth.web.controller.jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.persistance.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class JobsController {

    @Autowired
    private JobRepository jobRepository;

    private List<Job> allJobs = new ArrayList<>();

    @PostConstruct
    private void init() {
        allJobs = jobRepository.getAllJobs().stream()
                .collect(Collectors.toList());
    }

    public void lockJob(Job job) {
        job.setLocked(true);
    }

    public void unlockJob(Job job) {
        job.setLocked(false);
    }

    public List<Job> getAllJobs() {
        return allJobs;
    }

}
