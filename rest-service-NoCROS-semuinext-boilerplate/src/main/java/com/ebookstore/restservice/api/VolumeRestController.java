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


import com.ebookstore.restservice.domain.Volume;
import com.ebookstore.restservice.repository.VolumeRepository;
import com.ebookstore.restservice.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/volumes")
public class VolumeRestController {

    @Autowired
    VolumeService volumeService;

    @GetMapping
    public List<Volume> getAllVolumes() {
        List<Volume> volumes = volumeService.findAll();
        return volumes;
    }

    @GetMapping(path = "/{title}")
    public Volume getVolume(@PathVariable String title) {
        System.out.print(title);
        return volumeService.findOne(title);
    }

    /*
    @GetMapping(path="/search")
    public List<Volume>SearchVolumes(BookResourceQuery query){
        List<Volume> volumes=volumeService.findAllByQuery(query);
        return volumes;
    }
    */

}

