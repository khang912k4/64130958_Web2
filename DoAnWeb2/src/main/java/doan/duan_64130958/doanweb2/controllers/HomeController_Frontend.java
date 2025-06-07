package doan.duan_64130958.doanweb2.controllers;

import doan.duan_64130958.doanweb2.models.Event;
import doan.duan_64130958.doanweb2.models.Userr;
import doan.duan_64130958.doanweb2.models.Value;
import doan.duan_64130958.doanweb2.reposity.EventRepository;
import doan.duan_64130958.doanweb2.reposity.UserrRepository;
import doan.duan_64130958.doanweb2.reposity.ValueRepository;
import doan.duan_64130958.doanweb2.services.EventService;
import doan.duan_64130958.doanweb2.services.UserrService;
import doan.duan_64130958.doanweb2.services.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class HomeController_Frontend {

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

    @GetMapping("/site")
    public String showHomePage(){
        return "FrontEnd/index";
    }
    private String getTimeAgo(LocalDateTime createdAt) {
        Duration duration = Duration.between(createdAt, LocalDateTime.now());
        if (duration.toMinutes() < 1) return "Vừa đăng";
        if (duration.toMinutes() < 60) return "Đã đăng " + duration.toMinutes() + " phút trước";
        if (duration.toHours() < 24) return "Đã đăng " + duration.toHours() + " giờ trước";
        return "Đã đăng " + duration.toDays() + " ngày trước";
    }
    @GetMapping("/event")
    public String showEvent(Model model) throws IOException {
        String folderPath = System.getProperty("user.dir") + "/src/main/resources/images/";
        Path folder = Paths.get(folderPath);
        for (File file : Objects.requireNonNull(folder.toFile().listFiles())) {
            if(file.delete()){
                System.out.println(file.getName());
            }
        }
        model.addAttribute("pageCss", "/css/Frontend/events.css");
        List<Map<String, String>> events = new ArrayList<>();
        for (Event e : eventRepository.findAll()) {
            Map<String, String> eventMap = new HashMap<>();
            eventMap.put("title", e.getTitle());
            eventMap.put("tooltip", e.getMota());
            eventMap.put("timeAgo", getTimeAgo(e.getEventStart()));
            eventMap.put("link", "/eventdetail/" + e.getIdEvent());
            eventMap.put("id", String.valueOf(e.getIdEvent()));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e.getImage());
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            ImageIO.write(bufferedImage,"png",new File(System.getProperty("user.dir") + "/src/main/resources/images/SliEvent"+e.getIdEvent()+".png"));
            eventMap.put("image","http://localhost:8888/contents/images/SliEvent"+e.getIdEvent()+".png");
            events.add(eventMap);
        }
        model.addAttribute("events", events);
        
        return "FrontEnd/event";
    }
    @GetMapping("/eventdetail/{id}")
    public String showEventDetail(Model model,@PathVariable("id") Long id) throws IOException {
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

        List<Map<String,String>> values = new ArrayList<>();
        for (Value value: valueRepository.findByIdEvent(event.getIdEvent())){
            Map<String,String> valueMap = new HashMap<>();
            valueMap.put("name",value.getName());
            valueMap.put("valuet",String.valueOf(value.getValue()));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value.getImage());
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            ImageIO.write(bufferedImage,"png",new File(System.getProperty("user.dir") + "/src/main/resources/images/SliValue"+value.getIdValue()+".png"));
            valueMap.put("image","http://localhost:8888/contents/images/SliValue"+value.getIdValue()+".png");
            values.add(valueMap);
        }
//        String authorName = userrRepository.findById(event.getCreatedBy())
//                .map(Userr::getFullname)
//                .orElse("Không rõ");
        Random r = new Random();
        System.out.println("Hello"+event.getIdEvent());
        model.addAttribute("event", event);
        model.addAttribute("timeAgo", getTimeAgo(event.getEventStart()));
        model.addAttribute("values", values);
//        model.addAttribute("authorName", authorName);
        model.addAttribute("randomvalue",values.get(r.nextInt(values.size())));
        return "FrontEnd/event-detail";
    }
}