package com.example.deenoffice.repo;

import com.example.deenoffice.entity.DeanOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeanOfficeRepo extends JpaRepository<DeanOfficeEntity, Long> {
}
