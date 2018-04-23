package com.ebookstore.restservice.service;

import com.ebookstore.restservice.domain.Volume;
import com.ebookstore.restservice.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeService {
    @Autowired
    VolumeRepository volumeRepository;

    public List<Volume> findAll() {
        return volumeRepository.findAll();
    }

    public Volume findOne(String title) {

        return volumeRepository.findByTitle(title);
    }


    public Volume create(Volume volume) {

        return volumeRepository.save(volume);
    }

    public void delete(Long id) {
        volumeRepository.deleteById(id);
    }

    public Volume update(Volume volume) {
        return volumeRepository.save(volume);
    }
}