package com.informaticonfig.spring_boot.repository;

import com.informaticonfig.spring_boot.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {
}
