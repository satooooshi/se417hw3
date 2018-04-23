package com.ebookstore.restservice.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Arrays;
import com.ebookstore.restservice.api.EndWords;
import com.ebookstore.restservice.wordladder.WordLadder;
import com.ebookstore.restservice.wordladder.Lexicon;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;




@RestController
@RequestMapping("/api")
public class VolumeRestController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    protected ResourceLoader resourceLoader;




    private String sw;
    private String ew;

    //POST endwords
    //format : JSON Ex. {"startingWord":"coda","endingWord":"fade"}
    //curl -X POST -H 'Content-Type:application/json' -d '{"startingWord":"coda","endingWord":"fade"}' http://localhost:8080/api/testPOST
    @RequestMapping(value = "/endwords", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postWords(@RequestBody EndWords words){
        sw=words.getStaringWord();
        ew=words.getEndingWord();

        logger.info("Got startingWord "+sw+" and endingWord "+ew+" .");

        return "Got endingWords "+words.toString();
    }


    //GET
    @RequestMapping("/result")
    @ResponseBody
    public List<String> GetLadder() {

        logger.info("Start finding word ladder from "+sw+" to "+ ew+".");

        //Find word ladder here
        String pathAndFile = "static/dictionary.txt";
        Resource resource = resourceLoader.getResource("classpath:" + pathAndFile);
        logger.info("Dictionary found : "+resource.getFilename());
        Lexicon lexicon=new Lexicon(resource.getFilename());
        lexicon.addNewWord(sw);
        lexicon.addNewWord(ew);
        logger.info("Dictionary length : "+lexicon.getDictionary().size());
        WordLadder wordLadder=new WordLadder(sw,ew,lexicon.getDictionary());
        ArrayList<String>ladder=wordLadder.getFoundLadder();

        logger.info("Finish finding word ladder.");
        logger.info("Found : "+ladder);

        //String[] ladder = {"foo","bar","baz"};
        //return Arrays.asList(ladder);

        return ladder;
    }


    //*********************** Unrelated Codes From Here *************************************

    //GET -> hello will be on the page.
    @GetMapping("/testGET")
    public String testGet() {
        return "Hello";
    }

    //POST -> hey will not be on the page.
    //When
    //curl -X POST -H 'Content-Type:application/json' -d 'HELLO!!' http://localhost:8080/api/testPOST
    //Then
    //hey HELLO!!! will be shown up on terminal indicating POST success.
    @RequestMapping(
            value = "/testPOST",
            method = RequestMethod.POST,
            headers = {
                    "content-type=*",
                    "accept=application/json"
            }
    )
    //this return value directly become the responced contents.
    @ResponseBody
    public String testPost(@RequestBody String body) {
        return "Hey "+body+"!";

    //***************************************************************************
    }

}



