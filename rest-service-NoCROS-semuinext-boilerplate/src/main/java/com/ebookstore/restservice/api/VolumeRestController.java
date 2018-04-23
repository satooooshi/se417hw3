package com.ebookstore.restservice.api;

/*
import com.ebookstore.restservice.domain.Item;
import com.ebookstore.restservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
public class BookRestController {
    @Autowired
    ItemService itemService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Item> getItems() {
        List<Item> customers = itemService.findAll();
        return customers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Item postItem(@RequestBody Item item) {
        return itemService.create(item);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteItem(@PathVariable Integer id) {
        itemService.delete(id);
    }

    @PutMapping(path = "{id}")
    Item putItem(@PathVariable Integer id, @RequestBody Item item) {
        item.setId(id);
        return itemService.update(item);
    }

    @GetMapping(path = "{id}")
    Item getItem(@PathVariable Integer id) {
        Item item = itemService.findOne(id);
        return item;
    }

    @GetMapping("/home")
    public String index(@PathVariable String path){
        return "Hello! " + path;
    }

}

*/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Arrays;
import com.ebookstore.restservice.api.EndWords;



@RestController
@RequestMapping("/api")
public class VolumeRestController {

    protected final Log logger = LogFactory.getLog(getClass());


    private String sw;
    private String ew;

    //POST endwords
    //format : JSON Ex. {"startingWord":"coda","endingWord":"fade"}
    @RequestMapping(value = "/endwords", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postWords(@RequestBody EndWords words){
        sw=words.getStaringWord();
        ew=words.getEndingWord();

        logger.info("Got startingWord "+sw+" and "+ew+" .");

        return "Got endingWords "+words.toString();
    }


    //GET
    @RequestMapping("/result")
    @ResponseBody
    public List<String> GetLadder() {
        logger.info("Start finding word ladder from "+sw+" to "+ ew+".");
        //
        //MAKEWORDLADDERHERE
        //
        logger.info("Finish finding word ladder.");

        String[] ladder = {"foo","bar","baz"};
        return Arrays.asList(ladder);
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



