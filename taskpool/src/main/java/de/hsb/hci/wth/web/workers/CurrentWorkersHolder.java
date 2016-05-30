package de.hsb.hci.wth.web.workers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentWorkersHolder {

    public String getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getPrincipal().toString();
        }
        return "nobody";
    }

    private List<String> currentWorkers = new ArrayList<>();

    public List<String> getCurrentWorkers() {
        return currentWorkers;
    }

    @PostConstruct
    public void populateWorkersList() {
        currentWorkers.add("Mike");
        currentWorkers.add("Kevin");
    }
}
