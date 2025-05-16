package com.informaticonfig.spring_boot.repository;

import com.informaticonfig.spring_boot.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
