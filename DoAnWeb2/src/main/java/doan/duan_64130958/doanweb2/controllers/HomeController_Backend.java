package doan.duan_64130958.doanweb2.controllers;

import doan.duan_64130958.doanweb2.models.Event;
import doan.duan_64130958.doanweb2.models.Value;
import doan.duan_64130958.doanweb2.reposity.EventRepository;
import doan.duan_64130958.doanweb2.reposity.UserrRepository;
import doan.duan_64130958.doanweb2.reposity.ValueRepository;
import doan.duan_64130958.doanweb2.services.EventService;
import doan.duan_64130958.doanweb2.services.UserrService;
import doan.duan_64130958.doanweb2.services.ValueService;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
;

@Controller
public class HomeController_Backend {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ValueRepository valueRepository;
    @Autowired
    private ValueService valueService;
    @Autowired
    private UserrService userrService;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserrRepository userrRepository;

    @GetMapping("/")
    public String EditSite(Model model) {
        List<Map<String, String>> events = new ArrayList<>();
        for (Event e : eventRepository.findAll()) {
            Map<String, String> eventMap = new HashMap<>();
            eventMap.put("title", e.getTitle());
            eventMap.put("last_published", getTimeAgo(e.getEventStart()));
            eventMap.put("link", "/eventdetail/" + e.getIdEvent());
            eventMap.put("link_edit", "/editevent/" + e.getIdEvent());
            events.add(eventMap);
        }
        model.addAttribute("events", events);
        return "BackEnd/index";
    }
    @PostMapping("/")
    public String OutEditSite(Model model,
                              @RequestParam(value = "btn-add",required = false) String cl,
                              @RequestParam(value = "value") MultipartFile image) throws IOException {
        String folderPath = System.getProperty("user.dir") + "/src/main/resources/images/";
        Path folder = Paths.get(folderPath);
        for (File file : Objects.requireNonNull(folder.toFile().listFiles())) {
            if(file.delete()){
                System.out.println(file.getName());
            }
        }
        if(!Objects.equals(cl, null)) {
            Event event = new Event();
            event.setTitle("My Event");
            event.setEventEnd((LocalDateTime.now()).plusDays(10));
            event.setEventStart(LocalDateTime.now());
            BufferedImage img = ImageIO.read(image.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "png", baos);
            byte[] b = baos.toByteArray();
            event.setImage(b);
            event.setCreatedBy(1L);
            event.setMota("Event today");
            eventService.insertEventNative(event);
        }
        List<Map<String, String>> events = new ArrayList<>();
        for (Event e : eventRepository.findAll()) {
            Map<String, String> eventMap = new HashMap<>();
            eventMap.put("title", e.getTitle());
            eventMap.put("last_published", getTimeAgo(e.getEventStart()));
            eventMap.put("link", "/eventdetail/" + e.getIdEvent());
            eventMap.put("link_edit", "#");
            events.add(eventMap);
        }
        model.addAttribute("events", events);
        return "BackEnd/index";
    }
    @GetMapping("/editevent/{id}")
    public String EditSiteStyle(Model model,@PathVariable("id") Long id) {
        Optional<Event> eventOpt = eventRepository.findById(id);

        if(eventOpt.isEmpty()) return "redirect:/";
        Event event = eventOpt.get();

        model.addAttribute("event", event);

        return "BackEnd/edit-event";
    }
    @PostMapping("/editevent/{id}")
    public String OutEditSiteStyle(Model model,
                                   @PathVariable("id") Long id,
                                   @RequestParam(value = "btn-save",required = false) String cl,
                                   @RequestParam(value = "value",required = false) MultipartFile[] images,
                                   @RequestParam(value = "valuetext1",required = false) String[] names,
                                   @RequestParam(value = "valuetext2",required = false) Long[] values
                                   ) throws IOException {
        String folderPath = System.getProperty("user.dir") + "/src/main/resources/images/";
        Path folder = Paths.get(folderPath);
        for (File file : Objects.requireNonNull(folder.toFile().listFiles())) {
            if(file.delete()){
                System.out.println(file.getName());
            }
        }
        Optional<Event> eventOpt = eventRepository.findById(id);

        if(eventOpt.isEmpty()) return "redirect:/";
        Event event = eventOpt.get();
        boolean ok =true;
        if(!Objects.equals(cl, null)) {
            for(int i = 0; i < 9; i++){
                Value value = new Value();
                if(!images[i].isEmpty() && names[i] != null && values[i] != null){
                    if(ok){
                        valueService.deleteValue(event.getIdEvent());
                        ok=false;
                    }
                    BufferedImage img = ImageIO.read(images[i].getInputStream());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(img, "png", baos);
                    byte[] b = baos.toByteArray();
                    value.setImage(b);
                    value.setName(names[i]);
                    value.setValue(values[i]);
                    value.setIdEvent(event.getIdEvent());
                    valueService.insertValueNative(value);
                }
            }
        }


        model.addAttribute("event", event);


        return "BackEnd/edit-event";
    }


    private String getTimeAgo(LocalDateTime createdAt) {
        Duration duration = Duration.between(createdAt, LocalDateTime.now());
        if (duration.toMinutes() < 1) return "Vừa đăng";
        if (duration.toMinutes() < 60) return "Đã đăng " + duration.toMinutes() + " phút trước";
        if (duration.toHours() < 24) return "Đã đăng " + duration.toHours() + " giờ trước";
        return "Đã đăng " + duration.toDays() + " ngày trước";
    }
}