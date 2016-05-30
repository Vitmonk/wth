package de.hsb.hci.wth.web.data.entities;

import java.util.ArrayList;
import java.util.List;

public class MessageProtocol {

    private Integer jobId;
    private List<Message> messages = new ArrayList<>();

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
