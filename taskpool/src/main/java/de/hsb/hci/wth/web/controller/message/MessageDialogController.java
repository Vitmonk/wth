package de.hsb.hci.wth.web.controller.message;

import java.util.Date;

import javax.faces.view.ViewScoped;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.entities.Message;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class MessageDialogController {

    public void sendMessage(Device device, String text) {

        Message message = new Message();
        message.setTo(device.getId());
        message.setFrom("admin");
        message.setDate(new Date());
        message.setId((int) new Date().getTime());
        message.setContent(text);
        device.getMessages().add(message);
        Job currentJob = device.getCurrentJob();
        if (currentJob != null) {
            currentJob.getMessages().add(message);
        }
    }

}
