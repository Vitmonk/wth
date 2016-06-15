package de.hsb.hci.wth.web.controller.devices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.persistance.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class ChangeJobDialogController {

    @Autowired
    private JobRepository jobRepository;

    private Device device = null;
    private Job currentlyChosenJob = null;
    private List<Job> openJobs = new ArrayList<>();

    @PostConstruct
    private void init() {
        openJobs = jobRepository.getAllJobs().stream()
                .filter(job -> job.getCurrentDevice() == null && !job.isLocked())
                .collect(Collectors.toList());
    }

    public void changeJob() {
        if (currentlyChosenJob != null && device != null) {
            device.setCurrentJob(currentlyChosenJob);
            currentlyChosenJob.setCurrentDevice(device);
        }
    }

    public List<Job> getOpenJobs() {
        return openJobs;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Job getCurrentlyChosenJob() {
        return currentlyChosenJob;
    }

    public void setCurrentlyChosenJob(Job currentlyChosenJob) {
        this.currentlyChosenJob = currentlyChosenJob;
    }

}
