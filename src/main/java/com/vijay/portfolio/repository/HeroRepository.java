package com.vijay.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.portfolio.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Integer>{

}
