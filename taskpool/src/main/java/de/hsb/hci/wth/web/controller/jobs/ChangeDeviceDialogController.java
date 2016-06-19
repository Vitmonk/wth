package de.hsb.hci.wth.web.controller.jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.persistance.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class ChangeDeviceDialogController {

    @Autowired
    private DeviceRepository deviceRepository;

    private Job job = null;
    private Device currentlyChosenDevice = null;
    private List<Device> freeDevices = new ArrayList<>();
    private String filterValue = "";

    @PostConstruct
    private void init() {
        freeDevices = deviceRepository.getAllDevices().stream()
                .filter(device -> device.getCurrentJob() == null && !device.isLocked())
                .collect(Collectors.toList());
    }

    public void changeDevice() {
        if (currentlyChosenDevice != null && job != null) {
            currentlyChosenDevice.setCurrentJob(job);
            job.setCurrentDevice(currentlyChosenDevice);
        }
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Device getCurrentlyChosenDevice() {
        return currentlyChosenDevice;
    }

    public void setCurrentlyChosenDevice(Device currentlyChosenDevice) {
        this.currentlyChosenDevice = currentlyChosenDevice;
    }

    public List<Device> getFreeDevices() {
        return freeDevices;
    }

    public void setFreeDevices(List<Device> freeDevices) {
        this.freeDevices = freeDevices;
    }

}
