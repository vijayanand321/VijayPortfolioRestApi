package com.vijay.portfolio.service;

import com.vijay.portfolio.model.Hero;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HeroService {

    /**
     * Adds new hero data, including images.
     *
     * @param hero        The hero object containing the data.
     * @param images      The list of images to upload.
     * @return Hero       The saved hero object.
     * @throws IOException 
     */
    Hero addHero(Hero hero, List<MultipartFile> images) throws IOException;

    /**
     * Updates existing hero data.
     *
     * @param heroId      The ID of the hero to update.
     * @param hero        The hero object with updated data.
     * @param images      The list of images to upload.
     * @return Hero       The updated hero object.
     */
    Hero updateHero(Integer heroId, Hero hero, List<MultipartFile> images);

    /**
     * Retrieves the hero data.
     *
     * @return Hero       The current hero data.
     */
    Hero getHero();

    /**
     * Deletes the hero data by ID.
     *
     * @param heroId      The ID of the hero to delete.
     * @return boolean    True if the deletion was successful, otherwise false.
     */
    boolean deleteHero(Integer heroId);
}