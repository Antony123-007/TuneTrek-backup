package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.entity.PlayList;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList,Integer> {

}
