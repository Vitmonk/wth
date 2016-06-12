package de.hsb.hci.wth.web.controller.job;

import java.util.List;

import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class JobHelper {

    public Integer getProgress(Job job) {
        Integer progress = 0;
        List<Task> tasks = job.getTasks();

        Integer finished = (int) tasks.stream()
                .filter(task -> task.isCompleted())
                .count();
        progress = (int) ((finished * 1.0 / tasks.size() * 1.0) * 100);

        return progress;
    }

    public Task getCurrentTask(Job job) {
        Task currentTask = null;
        List<Task> tasks = job.getTasks();
        if (!tasks.isEmpty()) {
            currentTask = tasks.stream()
                    .filter(task -> !task.isCompleted())
                    .findFirst().get();
        }
        return currentTask;
    }

    public String getCurrentTaskName(Job job) {
        String currentTaskName = null;
        Task currentTask = getCurrentTask(job);
        if (currentTask != null) {
            currentTaskName = currentTask.getName();
        }
        return currentTaskName;
    }
}
