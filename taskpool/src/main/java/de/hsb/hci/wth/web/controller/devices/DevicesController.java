package de.hsb.hci.wth.web.controller.devices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.persistance.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class DevicesController {

    @Autowired
    private DeviceRepository deviceRepository;

    private List<Device> activeDevices = new ArrayList<>();

    @PostConstruct
    private void init() {
        activeDevices = deviceRepository.getAllDevices().stream()
                .filter(device -> device.getCurrentJob() != null)
                .collect(Collectors.toList());
    }

    public void lockDevice(Device device) {
        device.setLocked(true);
    }

    public void unlockDevice(Device device) {
        device.setLocked(false);
    }

    public List<Device> getActiveDevices() {
        return activeDevices;
    }

}
