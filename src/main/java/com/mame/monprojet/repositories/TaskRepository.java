package com.mame.monprojet.repositories;

import com.mame.monprojet.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository possède déjà les méthodes save, findAll, deleteById, etc.
}