package hello;

import java.util.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import hello.ServiceOne;


/*
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }



}
*/

@Controller
public class LadderController {

    protected final Log logger = LogFactory.getLog(getClass());


    @Autowired
    ServiceOne serviceOne;

    @RequestMapping("/home")
    String hello() {
        return "home";
    }

    @RequestMapping("/login")
    String login() {
        logger.info("I'm Login page.");
        return "login";
    }

    @RequestMapping("/output")
    String output() {
        return serviceOne.getName();
    }


    @RequestMapping("/endwords")
    public String endwords() {
        logger.info("Login succeed.");
        logger.info("I'm form page.");
        return "endwords";
    }

    @GetMapping("/wordladder")
    public String wordladder(Model model, @RequestParam(value="start", required=true) @NotBlank String start, @RequestParam(value="end", required=true) @NotBlank String end) {
        Lexicon lexicon=new Lexicon("https://raw.githubusercontent.com/satooooshi/se417hw3/dev/complete/src/main/resources/dictionary.txt");
        logger.info("start finding wordladder from "+start+" to "+end+" with dictionary at github.com/satooooshi"  );
        logger.info("wait for a sec to comlete finding wordladder, this would take about 20 seconds.");
        WordLadder wordladder=new WordLadder(start,end,lexicon.getDictionary());
        List<String>ladder=wordladder.getFoundLadder();
        logger.info("finishing finding ladder.");
        logger.info("found ladder :"+ladder);
        if(ladder!=null)
            model.addAttribute("foundladder",ladder);
        else
            model.addAttribute("foundladder","NOT found");

        return "wordladder";
    }
}