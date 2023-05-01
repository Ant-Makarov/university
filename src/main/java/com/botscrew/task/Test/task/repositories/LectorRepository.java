package com.botscrew.task.Test.task.repositories;

import com.botscrew.task.Test.task.models.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LectorRepository extends JpaRepository<Lector, UUID> {
    @Query("SELECT l FROM Lector l WHERE l.name LIKE %:template%  OR CAST(l.degree as string) LIKE %:template%")
    List<Lector> globalSearchByTemplate(@Param("template") String template);
}

