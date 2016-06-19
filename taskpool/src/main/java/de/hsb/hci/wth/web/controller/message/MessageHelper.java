package de.hsb.hci.wth.web.controller.message;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.entities.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

    public boolean hasUnreadedMessages(Device device) {
        boolean has = false;
        if (device != null) {
            String id = device.getId();
            for (Message message : device.getMessages()) {
                if (id.equals(message.getTo()) && !message.isRead()) {
                    has = true;
                    break;
                }
            }
        }
        return has;
    }

    public boolean hasUnreadedMessages(Job job) {
        boolean has = false;
        if (job != null) {
            for (Message message : job.getMessages()) {
                if ("admin".equals(message.getTo()) && !message.isRead()) {
                    has = true;
                    break;
                }
            }
        }
        return has;
    }
}
