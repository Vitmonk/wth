package de.hsb.hci.wth.web.model.persistance;

import java.util.List;

import de.hsb.hci.wth.web.model.entities.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceRepository {

    @Autowired
    private DemoDB demoDB;

    public List<Device> getAllDevices() {
        return demoDB.getDevices();
    }
}
