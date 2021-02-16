package com.spring.ionic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ionic.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
