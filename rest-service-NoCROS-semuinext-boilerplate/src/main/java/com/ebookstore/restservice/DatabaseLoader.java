package com.ebookstore.restservice;


import com.ebookstore.restservice.domain.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;


import com.ebookstore.restservice.repository.VolumeRepository;


@Component
public class DatabaseLoader implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired private VolumeRepository volumeRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Welcome to the online book store System!");
/*
        String links = "cover.jpeg";
        volumeRepository.save(new Volume("One Day","","David Nicholls","Fiction / Romance / Contemporary",
                "","","","",560,"",new Float(4.5),links));
                */
    }

    @Scheduled(initialDelayString = "${book.counter.delay}", fixedRateString = "${book.counter.rate}")
    public void run() {
        logger.info("Number of books: " + volumeRepository.count());
    }
}

//http://books.google.com/books/content?id=oqmBpk1EzvAC&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE711QBNtaIUSwWq78rKS255V9UdZGGvCLPHFe71mqh1MU9KhM2TmFFpSYInEoAmDyH43DB7HlgMn2RQD5Ui6zQNPIyNcyEAdDJmGcaBifZjypTM97qrD1I0Mcvq_U2_QW8VW_23J&source=gbs_api