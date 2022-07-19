package com.vmo.qlfresher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmo.qlfresher.entities.Fresher;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Integer>{

}
