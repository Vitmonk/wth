package de.hsb.hci.wth.web.model.persistance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import de.hsb.hci.wth.web.model.entities.Device;
import de.hsb.hci.wth.web.model.entities.Job;
import de.hsb.hci.wth.web.model.entities.Message;
import de.hsb.hci.wth.web.model.entities.Task;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoDB {

    private static final int AMOUNT_OF_DUMMY_ENTRIES = 30;

    private static final Log LOGGER = LogFactory.getLog(DemoDB.class);

    private List<Device> devices = new ArrayList<>();
    private List<Job> jobs = new ArrayList<>();

    @PostConstruct
    private void initDB() {
        LOGGER.info("Initialisiere Demo DB...");

        Message messageJob1Device1 = new Message();
        messageJob1Device1.setFrom("admin");
        messageJob1Device1.setTo("WRK102");
        messageJob1Device1.setDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.TUESDAY, 12, 10, 00)
                        .getTime());
        messageJob1Device1.setContent("Hallo Sie müssen arbeiten..");

        Task job1task1 = new Task();
        job1task1.setCompleted(false);
        job1task1.setName("Ware finden");
        job1task1.setDescription("Kiste XY für Ersatzteilen Serie 600/700 mit der Zusatzkodierung 12$3AX.");
        job1task1.setPackageCode("9783161484100");

        Task job1task2 = new Task();
        job1task1.setCompleted(false);
        job1task1.setName("Transporter beladen");
        job1task1.setDescription("Kiste XY in den Transporter in der Halle AC1 legen.");

        Job job1 = new Job();
        job1.setId(123);
        job1.setName("Transportvorbereitung XY");
        job1.setDescription("Kiste XY mit Ersatzteilen Serie 600/700 soll zum Transporter gebracht werden.");
        job1.getMessages().add(messageJob1Device1);
        job1.getTasks().add(job1task1);
        job1.getTasks().add(job1task2);
        job1.setCreationDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.MONDAY, 12, 10, 00)
                        .getTime());
        jobs.add(job1);

        Job job2 = new Job();
        job2.setId(456);
        job2.setName("Qualitätskontrolle");
        job2.setDescription("Pakete mit Verschleißteilen sollen geprüft werden.");
        job2.setCreationDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.JANUARY, 11, 20, 00)
                        .getTime());
        jobs.add(job2);

        Job job3 = new Job();
        job3.setId(789);
        job3.setName("Inventur von Ware ABC");
        job3.setDescription("Bestand der Pakete mit Ware ABC soll geprüft werden.");
        job3.setCreationDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.APRIL, 18, 40, 00)
                        .getTime());
        jobs.add(job3);

        Message messageJob4Device4 = new Message();
        messageJob4Device4.setFrom("admin");
        messageJob4Device4.setTo("WRK112");
        messageJob4Device4.setDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.TUESDAY, 12, 12, 00)
                        .getTime());
        messageJob4Device4.setContent("Hallo Sie müssen arbeiten..");
        messageJob4Device4.setRead(true);

        Task job4task1 = new Task();
        job4task1.setCompleted(true);
        job4task1.setName("Ware finden");
        job4task1.setDescription("Kiste XYZ für Ersatzteilen Serie 800 mit der Zusatzkodierung 43$2AC.");
        job4task1.setPackageCode("9783161484122");

        Task job4task2 = new Task();
        job4task2.setCompleted(false);
        job4task2.setName("Transporter beladen");
        job4task2.setDescription("Kiste XYZ in den Transporter in der Halle AC1 legen.");

        Job job4 = new Job();
        job4.setId(321);
        job4.setName("Transportvorbereitung XYZ");
        job4.setDescription("Kiste XYZ mit Ersatzteilen Serie 800 soll zum Transporter gebracht werden.");
        job4.getMessages().add(messageJob4Device4);
        job4.getTasks().add(job4task1);
        job4.getTasks().add(job4task2);
        job4.setCreationDate(new GregorianCalendar(
                2016, Calendar.AUGUST, Calendar.TUESDAY, 8, 10, 00)
                        .getTime());
        jobs.add(job4);

        Device device1 = new Device();
        devices.add(device1);
        device1.setId("WRK102");
        device1.setLastActive(
                new GregorianCalendar(
                        2016, Calendar.AUGUST, Calendar.TUESDAY, 14, 20, 00)
                                .getTime());
        device1.getMessages().add(messageJob1Device1);
        device1.setCurrentJob(job1);
        job1.setCurrentDevice(device1);

        Device device2 = new Device();
        devices.add(device2);
        device2.setId("WRK107");
        device2.setLastActive(
                new GregorianCalendar(
                        2016, Calendar.AUGUST, Calendar.TUESDAY, 17, 20, 30)
                                .getTime());

        Device device3 = new Device();
        devices.add(device3);
        device3.setId("WRK110");
        device3.setLastActive(
                new GregorianCalendar(
                        2016, Calendar.AUGUST, Calendar.TUESDAY, 12, 40, 35)
                                .getTime());

        Device device4 = new Device();
        devices.add(device4);
        device4.setId("WRK112");
        device4.setLastActive(
                new GregorianCalendar(
                        2016, Calendar.AUGUST, Calendar.TUESDAY, 10, 40, 35)
                                .getTime());
        device4.getMessages().add(messageJob4Device4);
        device4.setCurrentJob(job4);
        job4.setCurrentDevice(device4);

        createDummyEntries();

        LOGGER.info("Initialisierung der Demo DB abgeschlossen.");
    }

    private void createDummyEntries() {
        Random random = new Random();
        // Free
        for (int i = 0; i < AMOUNT_OF_DUMMY_ENTRIES; i++) {
            Job job = new Job();
            job.setId(300 + i);
            job.setName("Aufgabe " + 300 + i);
            job.setDescription("Beschreibung A" + 300 + i);
            job.setCreationDate(new GregorianCalendar(
                    2016, Calendar.AUGUST, Calendar.TUESDAY,
                    random.nextInt(24), random.nextInt(60), random.nextInt(60))
                            .getTime());
            Task task = new Task();
            task.setName("Let us dance =)");
            task.setDescription("Unteraufgabe von Aufgabe " + 300 + i);
            job.getTasks().add(task);

            jobs.add(job);

            Device device = new Device();
            device.setId("WRK" + 300 + i);
            device.setLastActive(new GregorianCalendar(
                    2016, Calendar.AUGUST, Calendar.TUESDAY,
                    random.nextInt(24), random.nextInt(60), random.nextInt(60))
                            .getTime());
            devices.add(device);
        }
        // Assigned
        for (int i = 0; i < AMOUNT_OF_DUMMY_ENTRIES; i++) {
            Job job = new Job();
            job.setId(400 + i);
            job.setName("Aufgabe " + 400 + i);
            job.setDescription("Beschreibung A" + 400 + i);
            job.setCreationDate(new GregorianCalendar(
                    2016, Calendar.AUGUST, Calendar.TUESDAY,
                    random.nextInt(24), random.nextInt(60), random.nextInt(60))
                            .getTime());
            Task task = new Task();
            task.setName("Let us dance =)");
            task.setDescription("Unteraufgabe von Aufgabe " + 400 + i);
            job.getTasks().add(task);

            jobs.add(job);

            Device device = new Device();
            device.setId("WRK" + 400 + i);
            device.setLastActive(new GregorianCalendar(
                    2016, Calendar.AUGUST, Calendar.TUESDAY,
                    random.nextInt(24), random.nextInt(60), random.nextInt(60))
                            .getTime());
            devices.add(device);

            device.setCurrentJob(job);
            job.setCurrentDevice(device);
        }
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}