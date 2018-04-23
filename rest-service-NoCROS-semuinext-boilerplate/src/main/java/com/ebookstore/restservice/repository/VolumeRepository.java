package com.ebookstore.restservice.repository;

import com.ebookstore.restservice.domain.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "books", path = "books")
@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {
    public Volume findVolumeByIsbn(String isbn);
    public List<Volume> findByAuthors(String author);
    public Volume findByTitle(String title);
}
