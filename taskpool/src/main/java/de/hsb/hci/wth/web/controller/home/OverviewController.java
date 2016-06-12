package de.hsb.hci.wth.web.controller.home;

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
public class OverviewController {

    @Autowired
    private JobRepository jobRepository;

    private List<Job> activeJobs = new ArrayList<>();
    private List<Job> openJobs = new ArrayList<>();

    @PostConstruct
    private void init() {
        activeJobs = jobRepository.getAllJobs().stream()
                .filter(job -> job.getCurrentDevice() != null)
                .collect(Collectors.toList());
        openJobs = jobRepository.getAllJobs().stream()
                .filter(job -> job.getCurrentDevice() == null && !job.isLocked())
                .collect(Collectors.toList());
    }

    public List<Job> getActiveJobs() {
        return activeJobs;
    }

    public List<Job> getOpenJobs() {
        return openJobs;
    }
}
