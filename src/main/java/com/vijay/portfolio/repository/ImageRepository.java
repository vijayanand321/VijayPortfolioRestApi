package com.vijay.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.portfolio.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
