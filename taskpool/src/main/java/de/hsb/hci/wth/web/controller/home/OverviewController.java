package de.hsb.hci.wth.web.controller.home;

import java.util.List;
import java.util.stream.Collectors;

import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.persistance.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OverviewController {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getActiveJobs() {
        return jobRepository.getAllJobs().stream()
                .filter(job -> job.getCurrentDevice() != null)
                .collect(Collectors.toList());
    }

    public List<Job> getOpenJobs() {
        return jobRepository.getAllJobs().stream()
                .filter(job -> job.getCurrentDevice() == null && !job.isLocked())
                .collect(Collectors.toList());
    }
}
